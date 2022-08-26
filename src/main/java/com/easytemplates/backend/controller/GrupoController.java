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

import com.easytemplates.backend.dto.Grupo;
import com.easytemplates.backend.service.GrupoServiceImpl;


@RestController
@RequestMapping("/api")
public class GrupoController {

	@Autowired
	GrupoServiceImpl grupoServiceImpl;
	
	@GetMapping("/grupos")
	public List<Grupo> listarGrupos() {
		return grupoServiceImpl.listAllGrupos();
	}

	@PostMapping("/grupos")
	public Grupo salvarGrupo(@RequestBody Grupo grupo) {

		return grupoServiceImpl.saveGrupo(grupo);
	}

	@GetMapping("/grupos/{id}")
	public Grupo grupoXID(@PathVariable(name = "id") Long id) {

		return grupoServiceImpl.gruposById(id);
	}

	@PutMapping("/grupos/{id}")
	public Grupo actualizarGrupo(@PathVariable(name = "id") Long id, @RequestBody Grupo grupo) {

		Grupo seleccionado = new Grupo();
		Grupo actualizado = new Grupo();

		seleccionado = grupoServiceImpl.gruposById(id);

		seleccionado.setNombre(grupo.getNombre());
		
		

		actualizado = grupoServiceImpl.updateGrupo(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/grupos/{id}")

	public void eliminarGrupo(@PathVariable(name = "id") Long id) {
		grupoServiceImpl.deleteGrupo(id);
	}
	
}