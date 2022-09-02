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

import com.easytemplates.backend.dto.UsuariosPlantillas;
import com.easytemplates.backend.service.UsuarioPlantillaServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioPlantillaController {
	@Autowired
	UsuarioPlantillaServiceImpl serviceImpl;
	
	@GetMapping("/usuarios_plantillas")
	public List<UsuariosPlantillas> listarUsuariosPlantillas() {
		return serviceImpl.listAllUsuariosPlantillas();
	}

	@PostMapping("/usuarios_plantillas")
	public UsuariosPlantillas salvarUsuariosPlantillas(@RequestBody UsuariosPlantillas usuario_plantilla) {

		return serviceImpl.saveUsuariosPlantillas(usuario_plantilla);
	}

	@GetMapping("/usuarios_plantillas/{id}")
	public UsuariosPlantillas usuariosPlantillasXID(@PathVariable(name = "id") Long id) {

		return serviceImpl.usuariosPlantillasById(id);
	}

	@PutMapping("/usuarios_plantillas/{id}")
	public UsuariosPlantillas actualizarUsuariosPlantillas(@PathVariable(name = "id") Long id, @RequestBody UsuariosPlantillas usuario_plantilla) {

		UsuariosPlantillas seleccionado = new UsuariosPlantillas();
		UsuariosPlantillas actualizado = new UsuariosPlantillas();

		seleccionado = serviceImpl.usuariosPlantillasById(id);

		seleccionado.setUsuarios(usuario_plantilla.getUsuarios());
		seleccionado.setPlantillas(usuario_plantilla.getPlantillas());
		
		

		actualizado = serviceImpl.updateUsuariosPlantillas(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/usuarios_plantillas/{id}")

	public void eliminarUsuariosImagenes(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteUsuariosPlantillas(id);
	}
}
