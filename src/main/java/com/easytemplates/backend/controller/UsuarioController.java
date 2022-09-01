package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dto.Usuario;
import com.easytemplates.backend.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuarioController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return usuarioServiceImpl.listAllUsuarios();
	}

	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@PostMapping("/usuarios")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {

		return usuarioServiceImpl.saveUsuario(usuario);
	}

	@GetMapping("/usuarios/{id}")
	public Usuario usuarioXID(@PathVariable(name = "id") Long id) {

		return usuarioServiceImpl.usuarioById(id);
	}

	@GetMapping("/usuarios/{username}")
	public Usuario userByUsername(@PathVariable(name = "nombre")String username) {
		return usuarioServiceImpl.usuarioByUsername(username);
	}
	
	@PutMapping("/usuarios/{id}")
	public Usuario actualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {

		Usuario seleccionado = new Usuario();
		Usuario actualizado = new Usuario();

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