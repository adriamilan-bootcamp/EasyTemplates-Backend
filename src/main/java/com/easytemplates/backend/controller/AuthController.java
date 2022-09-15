package com.easytemplates.backend.controller;

import static com.easytemplates.backend.security.SecurityConstants.REGISTER_URL;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Role;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.service.UsuarioServiceImpl;

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
	
	@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/admin", method = RequestMethod.GET)
	public ResponseEntity<String> test()
	{
		return ResponseEntity.ok()
			      .body("Admin role works perfectly!");
	}
	
	@PostMapping(REGISTER_URL)
	public ResponseEntity<String> registrarUsuario(@RequestBody UserDetailsRequestModel requestUserDetails) {
		Usuarios usuarioNuevo = new Usuarios();
		
		if (usuarioDAO.findByEmail(requestUserDetails.getEmail()) != null) {
			  System.out.println("Email is already registered!");
			  return ResponseEntity.badRequest()
				      .body("Email is already registered!");
		}
		
		BeanUtils.copyProperties(requestUserDetails, usuarioNuevo);
		
		usuarioNuevo.addRole(new Role(2));

		String encoded = bCryptPasswordEncoder.encode(requestUserDetails.getPassword());
		usuarioNuevo.setPassword(encoded);
		
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
