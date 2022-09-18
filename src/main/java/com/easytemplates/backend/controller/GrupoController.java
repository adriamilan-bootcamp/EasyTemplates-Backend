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

import com.easytemplates.backend.dao.IGrupoDAO;
import com.easytemplates.backend.dto.Grupos;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.service.GrupoServiceImpl;


@RestController
@RequestMapping("/api")
public class GrupoController {

	
	@Autowired
	GrupoServiceImpl grupoServiceImpl;
	
	@Autowired
	IGrupoDAO iGrupoDAO;
	
	@GetMapping("/grupos")
	public List<Grupos> listarGrupos() {
		return grupoServiceImpl.listAllGrupos();
	}

	@PostMapping("/grupos")
	public Grupos salvarGrupo(@RequestBody Grupos grupo) {

		return grupoServiceImpl.saveGrupo(grupo);
	}

	@GetMapping("/grupos/{id}")
	public Grupos grupoXID(@PathVariable(name = "id") Long id) {

		return grupoServiceImpl.gruposById(id);
	}

	@GetMapping("/grupos/name/{nombre}")
	public List<Grupos> grupoXNombre(@PathVariable(name = "nombre") String nombre) {

		return iGrupoDAO.findGruposByNombre(nombre);
	}

	
	@GetMapping("/grupos/usuarios/id/{id}")
	public List<Grupos> usuarioXGrupos(@PathVariable(name = "id") Long id) {

		return iGrupoDAO.findGruposByUsuariosId(id);
	}

	
	@PutMapping("/grupos/{id}")
	public Grupos actualizarGrupo(@PathVariable(name = "id") Long id, @RequestBody Grupos grupo) {

		Grupos seleccionado = new Grupos();
		Grupos actualizado = new Grupos();

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