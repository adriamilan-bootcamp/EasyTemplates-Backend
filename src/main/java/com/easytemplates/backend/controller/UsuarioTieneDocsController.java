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

import com.easytemplates.backend.dto.UsuarioTieneDocs;
import com.easytemplates.backend.service.PdfServiceImpl;
import com.easytemplates.backend.service.UsuarioTieneDocsServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioTieneDocsController {

	@Autowired
	UsuarioTieneDocsServiceImpl utdCtl;
	
	@GetMapping("/usuariotienedocs")
	public List<UsuarioTieneDocs> getAllUsuarioTieneDocs() {
		return utdCtl.listAllUsuarioTieneDocs();
	}
	
	@PostMapping("/usuariotienedocs")
	public UsuarioTieneDocs saveAllUsuarioTieneDocs(@RequestBody UsuarioTieneDocs u) {
		return utdCtl.saveUsuarioTieneDocs(u);
	}
	
	@GetMapping("/usuariotienedocs/{id}")
	public UsuarioTieneDocs getUsuarioTieneDocsById(@PathVariable(name = "id") Long id) {
		return utdCtl.usuarioTieneDocsById(id);
	}
	
	@PutMapping("/usuariotienedocs/{id}")
	public UsuarioTieneDocs updateUsuarioTieneDocs(@PathVariable(name = "id") Long id, @RequestBody UsuarioTieneDocs u) {
		UsuarioTieneDocs updatedUsuarioTieneDocs;

		updatedUsuarioTieneDocs = utdCtl.usuarioTieneDocsById(id);

		utdCtl.saveUsuarioTieneDocs(updatedUsuarioTieneDocs);

		return updatedUsuarioTieneDocs;
	}
	
	@DeleteMapping("/usuariotienedocs/{id}")
	public void deleteUsuarioTieneDocs(@PathVariable(name = "id") Long id) {
		utdCtl.deleteUsuarioTieneDocs(id);
	}
}