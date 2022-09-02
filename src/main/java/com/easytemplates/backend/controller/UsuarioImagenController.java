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



import com.easytemplates.backend.dto.UsuariosImagenes;
import com.easytemplates.backend.service.UsuarioImagenServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioImagenController {

	@Autowired
	UsuarioImagenServiceImpl serviceImpl;
	
	@GetMapping("/usuarios_imagenes")
	public List<UsuariosImagenes> listarUsuariosImagenes() {
		return serviceImpl.listAllUsuariosImagenes();
	}

	@PostMapping("/usuarios_imagenes")
	public UsuariosImagenes salvarUsuariosImagenes(@RequestBody UsuariosImagenes usuario_imagen) {

		return serviceImpl.saveUsuariosImagenes(usuario_imagen);
	}

	@GetMapping("/usuarios_imagenes/{id}")
	public UsuariosImagenes usuariosImagenesXID(@PathVariable(name = "id") Long id) {

		return serviceImpl.usuariosImagenesById(id);
	}

	@PutMapping("/usuarios_imagenes/{id}")
	public UsuariosImagenes actualizarUsuariosImagenes(@PathVariable(name = "id") Long id, @RequestBody UsuariosImagenes usuario_imagen) {

		UsuariosImagenes seleccionado = new UsuariosImagenes();
		UsuariosImagenes actualizado = new UsuariosImagenes();

		seleccionado = serviceImpl.usuariosImagenesById(id);

		seleccionado.setUsuarios(usuario_imagen.getUsuarios());
		seleccionado.setImagenes(usuario_imagen.getImagenes());
		
		

		actualizado = serviceImpl.updateUsuariosImagenes(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/usuarios_imagenes/{id}")

	public void eliminarUsuariosImagenes(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteUsuariosImagenes(id);
	}
	
}