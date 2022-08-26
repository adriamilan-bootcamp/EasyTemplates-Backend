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

import com.easytemplates.backend.dto.GrupoTieneDocs;
import com.easytemplates.backend.service.GrupoTieneDocsServiceImpl;

@RestController
@RequestMapping("/api")
public class GrupoTieneDocsController {

	@Autowired
	GrupoTieneDocsServiceImpl gtdCtl;
	
	@GetMapping("/grupostienendocs")
	public List<GrupoTieneDocs> getAllGrupoTieneDocs() {
		return gtdCtl.listAllGrupoTieneDocs();
	}
	
	@PostMapping("/grupostienendocs")
	public GrupoTieneDocs saveGrupoTieneDocs(@RequestBody GrupoTieneDocs g) {
		return gtdCtl.saveGrupoTieneDocs(g);
	}
	
	@GetMapping("/grupostienendocs/{id}")
	public GrupoTieneDocs getGrupoTieneDocsById(@PathVariable(name = "id") Long id) {
		return gtdCtl.grupoTieneDocsById(id);
	}
	
	@PutMapping("/grupostienendocs/{id}")
	public GrupoTieneDocs updateGrupoTieneDocs(@PathVariable(name = "id") Long id, @RequestBody GrupoTieneDocs g) {
		GrupoTieneDocs updatedGrupoTieneDocs;

		updatedGrupoTieneDocs = gtdCtl.grupoTieneDocsById(id);

		gtdCtl.saveGrupoTieneDocs(updatedGrupoTieneDocs);

		return updatedGrupoTieneDocs;
	}
	
	@DeleteMapping("/grupostienendocs/{id}")
	public void deleteGrupoTieneDocs(@PathVariable(name = "id") Long id) {
		gtdCtl.deleteGrupoTieneDocs(id);
	}
}
