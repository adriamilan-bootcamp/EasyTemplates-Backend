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

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.service.UsuarioServiceImpl;

import static com.easytemplates.backend.security.SecurityConstants.REGISTER_URL;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	IUsuarioDAO usuarioDAO;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public AuthController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@PostMapping(REGISTER_URL)
	public ResponseEntity<String> registrarUsuario(@RequestBody Usuarios usuario) {
		HttpHeaders responseHeaders = new HttpHeaders();
		Usuarios usuarioNuevo = new Usuarios();
		
		if (usuarioDAO.findByEmail(usuario.getEmail()) != null) {
			  System.out.println("Email is already registered!");
			  return ResponseEntity.badRequest()
				      .body("Email is already registered!");
		}
		
		usuarioNuevo.setNombre(usuario.getNombre());
		usuarioNuevo.setEmail(usuario.getEmail());
		usuarioNuevo.setRol(Usuarios.Rol.USER);
		
		String encoded = bCryptPasswordEncoder.encode(usuario.getPassword());
		usuarioNuevo.setPassword(encoded);
		
		
		usuarioNuevo.setLockFlag(0);
		usuarioServiceImpl.saveUsuario(usuarioNuevo);
		
		return ResponseEntity.ok()
			      .body("User registered succesfully!");
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
