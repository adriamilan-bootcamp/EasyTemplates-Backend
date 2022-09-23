package com.easytemplates.backend.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.easytemplates.backend.dao.IPdfDAO;
import com.easytemplates.backend.dto.Pdfs;
import com.easytemplates.backend.security.SecurityLogging;
import com.easytemplates.backend.service.PdfServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class PdfController {

	@Autowired
	PdfServiceImpl pdfCtl;
	@Autowired
	IPdfDAO iPdfDAO;
	private Gson gson = new Gson();
	
	@GetMapping(value = "/pdfs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pdfs> listAllPdfs() {
		return pdfCtl.listAllPdfs();
	}
	
	@GetMapping("/pdfs/{id}")
	public Pdfs getPdfById(@PathVariable(name = "id") Long id) {
		return pdfCtl.pdfById(id);
	}
	
	@GetMapping("/pdfs/titulo")
	public List<Pdfs> pdfXtitulo(@RequestParam(name = "titulo") String titulo) {

		return iPdfDAO.findByTitulo(titulo);
	}
	
	@PutMapping("/pdfs/{id}")
	public Pdfs updatePdf(@PathVariable(name = "id") Long id, @RequestBody Pdfs p) {
		Pdfs updatedPdf;
		
		updatedPdf = pdfCtl.pdfById(id);

		updatedPdf.setTitulo(p.getTitulo());
		updatedPdf.setSrc(p.getSrc());

		pdfCtl.savePdf(updatedPdf);

		return updatedPdf;
	}
	
	@DeleteMapping(value = "/pdfs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletePdf(@PathVariable(name = "id") Long id) {
		pdfCtl.deletePdf(id);
		
		JsonObject json = new JsonObject();
		json.addProperty("msg", "Pdf deleted successfully!");
		
		return this.gson.toJson(json);
	}
	
	/**
	 * 	Amazon S3
	 */

	@PostMapping("/pdfs") 
	public ResponseEntity<String> uploadPdf(@RequestPart(value="file") MultipartFile file,
			@RequestParam(name = "titulo") String titulo) throws Exception {
		
			pdfCtl.uploadFile(file, titulo);
			
			JsonObject json = new JsonObject();
			json.addProperty("msg", "El archivo " + file.getOriginalFilename() + " fue subido correctamente a s3!");
			
			return new ResponseEntity<>(this.gson.toJson(json), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/pdfs/s3/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ByteArrayResource> getTemplateFromS3(@PathVariable(name="id") Long id) {
		Pdfs pdf = pdfCtl.pdfById(id);
		
		String url = pdf.getSrc();
		
		String escape = "[^/\\\\&\\?]+\\.\\w{3,4}(?=([\\?&].*$|$))";
		
		final Pattern pattern = Pattern.compile(escape, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(url);

        matcher.find();
        
        SecurityLogging.logMsg("PDF-S3", "Downloading " + matcher.group(0));
        
        byte[] data = pdfCtl.downloadFile(matcher.group(0));
        
        ByteArrayResource resource = new ByteArrayResource(data);
        
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/pdf")
                .header("Content-disposition", "attachment; filename=\"" + matcher.group(0).toString() + "\"")
                .body(resource);
	}
}
