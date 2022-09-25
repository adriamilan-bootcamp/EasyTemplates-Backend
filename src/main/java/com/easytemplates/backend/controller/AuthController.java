package com.easytemplates.backend.controller;

import static com.easytemplates.backend.security.SecurityConstants.REGISTER_URL;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Role;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.security.SecurityLogging;
import com.easytemplates.backend.service.RoleServiceImpl;
import com.easytemplates.backend.service.UsuarioServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	RoleServiceImpl roleSvc;
	
	@Autowired
	IUsuarioDAO usuarioDAO;
	
	private Gson gson = new Gson();

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public AuthController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping(value = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getRoles() {		
		// JSON Object
		JsonObject json = new JsonObject();

		// Roles Key Pair
		json.addProperty("roles", SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString()
				.replace("[", "")
			    .replace("]", ""));

		String userJsonString = this.gson.toJson(json);
		
		return ResponseEntity.ok()
			      .body(userJsonString);
	}	
	
	@PostMapping(value = REGISTER_URL, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registrarUsuario(@RequestBody UserDetailsRequestModel requestUserDetails) {
		Usuarios usuarioNuevo = new Usuarios();
		
		JsonObject json = new JsonObject();
		
		if (usuarioDAO.findByEmail(requestUserDetails.getEmail()) != null) {
			  SecurityLogging.logMsg("REGISTER", "Email is already registered!");
			  json.addProperty("msg", "Email is already registered!");
			  return ResponseEntity.badRequest()
				      .body(this.gson.toJson(json));
		}
		
		usuarioNuevo.setEmail(requestUserDetails.getEmail());
		usuarioNuevo.setUsername(requestUserDetails.getUsername());
		
		Role role = roleSvc.findByName("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        
        usuarioNuevo.setRoles(roleSet);
        
		String encoded = bCryptPasswordEncoder.encode(requestUserDetails.getPassword());
		usuarioNuevo.setPassword(encoded);
		
		usuarioServiceImpl.saveUsuario(usuarioNuevo);
		
		json.addProperty("msg", "Registered successfully!");
		
		return ResponseEntity.ok()
			      .body(this.gson.toJson(json));
	}
}
