package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dto.Pdf;
import com.easytemplates.backend.service.PdfServiceImpl;

@RestController
@RequestMapping("/api")
public class PdfController {

	@Autowired
	PdfServiceImpl pdfCtl;
	
	@GetMapping("/pdfs")
	public List<Pdf> listAllPdfs() {
		return pdfCtl.listAllPdfs();
	}
	
	@PostMapping("/pdfs")
	public Pdf savePdf(@RequestBody Pdf p) {
		return pdfCtl.savePdf(p);
	}
	
	@GetMapping("/pdfs/{id}")
	public Pdf getPdfById(@PathVariable(name = "id") Long id) {
		return pdfCtl.pdfById(id);
	}
	
	@PutMapping("/pdfs/{id}")
	public Pdf updatePdf(@PathVariable(name = "id") Long id, @RequestBody Pdf p) {
		Pdf updatedPdf;
		
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