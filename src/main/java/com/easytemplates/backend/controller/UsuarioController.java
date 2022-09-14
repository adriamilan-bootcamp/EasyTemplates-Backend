package com.easytemplates.backend.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuarioController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/usuarios")
	public List<Usuarios> listarUsuarios() {
		return usuarioServiceImpl.listAllUsuarios();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Object> usuarioXID(@PathVariable(name = "id") Long id) {
		
		Usuarios user = usuarioServiceImpl.usuarioById(id);
		
		if (user != null)
		{
			// Simple way to build a JSON Object
			HashMap<String, String> userInfo = new HashMap<>();
			
			// Non-admin clients don't need more information
			userInfo.put("email", user.getEmail());
			userInfo.put("username", user.getNombre());
		    
			return new ResponseEntity<Object>(userInfo, HttpStatus.UNAUTHORIZED);
		}
	
		return new ResponseEntity<Object>("The specified user doesn\'t exist in the database, try registering it", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> actualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody UserDetailsRequestModel requestUserDetails) {
		Usuarios user = usuarioServiceImpl.usuarioById(id);
		
		if (user != null)
		{
			String targetUserEmail = usuarioServiceImpl.usuarioById(id).getEmail();
			String authedUserEmail = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
			
			
			if (targetUserEmail.equals(authedUserEmail))
			{
				String encoded = bCryptPasswordEncoder.encode(requestUserDetails.getPassword());
				
				user.setNombre(requestUserDetails.getNombre());
				user.setEmail(requestUserDetails.getEmail());
				user.setPassword(encoded);
				
				usuarioServiceImpl.updateUsuario(user);
				
				return new ResponseEntity<Object>(user, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Object>("You are not authorized to edit other user\'s acounts", HttpStatus.UNAUTHORIZED);
			}
		}
	
		return new ResponseEntity<Object>("The specified user doesn\'t exist in the database, try registering it", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable(name = "id") Long id) {
		usuarioServiceImpl.deleteUsuario(id);
	}
	
}