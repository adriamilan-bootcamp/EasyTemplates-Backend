package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dto.Pdfs;
import com.easytemplates.backend.service.PdfServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class PdfController {

	@Autowired
	PdfServiceImpl pdfCtl;

	private Gson gson = new Gson();
	
	@GetMapping(value = "/pdfs", produces = MediaType.APPLICATION_JSON_VALUE)
	public String listAllPdfs() {
		
		List<Pdfs> pdfs = pdfCtl.listAllPdfs();
		
		JsonObject json = new JsonObject();
		JsonObject jsonfather = new JsonObject();

		for (int i = 0; i < pdfs.size(); i++) {
			json.addProperty("src", pdfs.get(i).getSrc().toString());
			json.addProperty("title", pdfs.get(i).getTitulo().toString());
			jsonfather.getAsJsonObject().add(String.valueOf(pdfs.get(i).getId()), (JsonElement) gson.toJsonTree(json));
		}

		String userJsonString = this.gson.toJson(jsonfather);

		return userJsonString;
	}
	
	@PostMapping("/pdfs")
	public Pdfs savePdf(@RequestBody Pdfs p) {
		return pdfCtl.savePdf(p);
	}
	
	@GetMapping("/pdfs/{id}")
	public Pdfs getPdfById(@PathVariable(name = "id") Long id) {
		return pdfCtl.pdfById(id);
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
	
	@DeleteMapping("/pdfs/{id}")
	public void deletePdf(@PathVariable(name = "id") Long id) {
		pdfCtl.deletePdf(id);
	}
}