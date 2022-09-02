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

import com.easytemplates.backend.dto.GruposPdfs;
import com.easytemplates.backend.service.GrupoPdfServiceImpl;



@RestController
@RequestMapping("/api")
public class GrupoPdfController {
	@Autowired
	GrupoPdfServiceImpl serviceImpl;
	
	@GetMapping("/grupos_pdfs")
	public List<GruposPdfs> listarGruposPdfs() {
		return serviceImpl.listAllGruposPdfs();
	}

	@PostMapping("/grupos_pdfs")
	public GruposPdfs salvarGruposPdfs(@RequestBody GruposPdfs grupo_pdf) {

		return serviceImpl.saveGruposPdfs(grupo_pdf);
	}

	@GetMapping("/grupos_pdfs/{id}")
	public GruposPdfs gruposPdfsXID(@PathVariable(name = "id") Long id) {

		return serviceImpl.gruposPdfsById(id);
	}

	@PutMapping("/grupos_pdfs/{id}")
	public GruposPdfs actualizarGruposPdfs(@PathVariable(name = "id") Long id, @RequestBody GruposPdfs grupo_pdf) {

		GruposPdfs seleccionado = new GruposPdfs();
		GruposPdfs actualizado = new GruposPdfs();

		seleccionado = serviceImpl.gruposPdfsById(id);

		seleccionado.setGrupos(grupo_pdf.getGrupos());
		seleccionado.setPdfs(grupo_pdf.getPdfs());
		
		

		actualizado = serviceImpl.updateGruposPdfs(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/grupos_pdfs/{id}")

	public void eliminarGruposPdfs(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteGruposPdfs(id);
	}
}
