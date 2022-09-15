package com.easytemplates.backend.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dto.Role;
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
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>("The specified user doesn\'t exist in the database, try registering it", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 *  The user will have to login again (JWT Bearer Token is invalid after new user details)
	 */
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> actualizarUsuario(@PathVariable(name = "id") Long id, @RequestBody UserDetailsRequestModel requestUserDetails) {
		Usuarios user = usuarioServiceImpl.usuarioById(id);
		
		if (user != null)
		{
			String targetUserEmail = usuarioServiceImpl.usuarioById(id).getEmail();
			String authedUserEmail = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail();
			
			Set<Role> userRoles = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRoles();
			
			HashSet<String> userRolesArray = new HashSet<String>(userRoles.size());
			
			// Map each role name to a Strings HashSet
			for(Role role : userRoles) {
				userRolesArray.add(role.toString());
			}
			
			if (targetUserEmail.equals(authedUserEmail) || userRolesArray.contains("ROLE_ADMIN") == true)
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

	/**
	 *  The user will have to login again (JWT Bearer Token is invalid)
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Object> eliminarUsuario(@PathVariable(name = "id") Long id) {
		Usuarios user = usuarioServiceImpl.usuarioById(id);
		
		if (user != null)
		{
			usuarioServiceImpl.deleteUsuario(id);
			return new ResponseEntity<Object>("User deleted successfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>("The specified user doesn\'t exist in the database, won't delete", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}