package com.easytemplates.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.service.UsuarioServiceImpl;

import static com.easytemplates.backend.security.SecurityConstants.REGISTER_URL;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public AuthController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping(REGISTER_URL)
	public Usuarios registrarUsuario(@RequestBody Usuarios usuario) {
		Usuarios usuarioNuevo = new Usuarios();
		usuarioNuevo.setNombre(usuario.getNombre());
		usuarioNuevo.setEmail(usuario.getEmail());
		usuarioNuevo.setRole("user");
		
		String encoded = bCryptPasswordEncoder.encode(usuario.getPassword());
		usuarioNuevo.setPassword(encoded);
		
		
		usuarioNuevo.setLockFlag(0);
		return usuarioServiceImpl.saveUsuario(usuarioNuevo);
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
}