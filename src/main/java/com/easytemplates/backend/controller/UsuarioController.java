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

import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping("/usuarios")
	public List<Usuarios> listarUsuarios() {
		return usuarioServiceImpl.listAllUsuarios();
	}

	@PostMapping("/usuarios")
	public Usuarios salvarUsuario(@RequestBody Usuarios usuario) {

		return usuarioServiceImpl.saveUsuario(usuario);
	}

	@GetMapping("/usuarios/{id}")
	public Usuarios usuarioXID(@PathVariable(name = "id") Long id) {

		return usuarioServiceImpl.usuarioById(id);
	}

	@PutMapping("/usuarios/{id}")
	public Usuarios actualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody Usuarios usuario) {

		Usuarios seleccionado = new Usuarios();
		Usuarios actualizado = new Usuarios();

		seleccionado = usuarioServiceImpl.usuarioById(id);

		seleccionado.setNombre(usuario.getNombre());
		seleccionado.setEmail(usuario.getEmail());
		seleccionado.setPassword(usuario.getPassword());
		

		actualizado = usuarioServiceImpl.updateUsuario(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/usuarios/{id}")

	public void eliminarUsuario(@PathVariable(name = "id") Long id) {
		usuarioServiceImpl.deleteUsuario(id);
	}
	
}