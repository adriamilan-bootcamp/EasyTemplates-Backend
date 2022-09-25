package com.easytemplates.backend.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Role;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.service.UsuarioServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	@Autowired
	IUsuarioDAO iUsuarioDAO;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private Gson gson = new Gson();

	public UsuarioController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping(value = "/usuarios/user_id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getId() {		
		// JSON Object
		JsonObject json = new JsonObject();

		// Id Key Pair
		json.addProperty("id", String.valueOf(((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId())
				.replace("[", "")
			    .replace("]", ""));

		String userJsonString = this.gson.toJson(json);
		
		return ResponseEntity.ok()
			      .body(userJsonString);
	}
	
	@GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public String listarUsuarios() {
		List<Usuarios> user = usuarioServiceImpl.listAllUsuarios();

		JsonObject json = new JsonObject();
		JsonArray array = new JsonArray();

		Set<Role> userRoles = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getRoles();

		HashSet<String> userRolesArray = new HashSet<String>(userRoles.size());

		// Map each role name to a Strings HashSet
		for (Role role : userRoles) {
			userRolesArray.add(role.toString());
		}

		for (int i = 0; i < user.size(); i++) {
			json.addProperty("id", String.valueOf(user.get(i).getId()));
			json.addProperty("username", user.get(i).getUsername());
			json.addProperty("email", user.get(i).getEmail());
			json.addProperty("firma", user.get(i).getFirma());
			json.addProperty("password", user.get(i).getPassword());

				json.addProperty("roles",
						user.get(i).getAuthorities().toString().replace("[", "").replace("]", "").replace("ROLE_", ""));

			array.add(gson.toJsonTree(json));
		}

		String userJsonString = this.gson.toJson(array);

		return userJsonString;
	}

	@GetMapping(value = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String usuarioXID(@PathVariable(name = "id") Long id) {

		Usuarios user = usuarioServiceImpl.usuarioById(id);

		JsonObject json = new JsonObject();
		Set<Role> userRoles = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getRoles();

		HashSet<String> userRolesArray = new HashSet<String>(userRoles.size());

		// Map each role name to a Strings HashSet
		for (Role role : userRoles) {
			userRolesArray.add(role.toString());
		}

		json.addProperty("id", String.valueOf(user.getId()));
		json.addProperty("username", user.getUsername());
		json.addProperty("email", user.getEmail());
		json.addProperty("firma", user.getFirma());
		json.addProperty("password", user.getPassword());

			json.addProperty("roles",
					user.getAuthorities().toString().replace("[", "").replace("]", "").replace("ROLE_", ""));

		String userJsonString = this.gson.toJson(json);

		return userJsonString;
	}

	@GetMapping(value = "/usuarios/name/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String usuarioXNombre(@PathVariable(name = "nombre") String nombre) {

		List<Usuarios> user = iUsuarioDAO.findByUsername(nombre);

		JsonObject json = new JsonObject();
		JsonArray array = new JsonArray();

		Set<Role> userRoles = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getRoles();

		HashSet<String> userRolesArray = new HashSet<String>(userRoles.size());

		// Map each role name to a Strings HashSet
		for (Role role : userRoles) {
			userRolesArray.add(role.toString());
		}

		for (int i = 0; i < user.size(); i++) {
			json.addProperty("id", String.valueOf(user.get(i).getId()));
			json.addProperty("username", user.get(i).getUsername());
			json.addProperty("email", user.get(i).getEmail());
			json.addProperty("firma", user.get(i).getFirma());
			json.addProperty("password", user.get(i).getPassword());

				json.addProperty("roles",
						user.get(i).getAuthorities().toString().replace("[", "").replace("]", "").replace("ROLE_", ""));

			array.add(gson.toJsonTree(json));
		}

		String userJsonString = this.gson.toJson(array);

		return userJsonString;
	}

	@GetMapping("/usuarios/email/{email}")
	public String usuarioXemail(@PathVariable(name = "email") String email) {

		Usuarios user = iUsuarioDAO.findByEmail(email);
		
		JsonObject json = new JsonObject();
		Set<Role> userRoles = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getRoles();

		HashSet<String> userRolesArray = new HashSet<String>(userRoles.size());

		// Map each role name to a Strings HashSet
		for (Role role : userRoles) {
			userRolesArray.add(role.toString());
		}

		json.addProperty("id", String.valueOf(user.getId()));
		json.addProperty("username", user.getUsername());
		json.addProperty("email", user.getEmail());
		json.addProperty("firma", user.getFirma());
		json.addProperty("password", user.getPassword());

			json.addProperty("roles",
					user.getAuthorities().toString().replace("[", "").replace("]", "").replace("ROLE_", ""));

		String userJsonString = this.gson.toJson(json);

		return userJsonString;
	}

	/**
	 * The user will have to login again (JWT Bearer Token is invalid after new user
	 * details)
	 */
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> actualizarUsuario(@PathVariable(name = "id") Long id,
			@RequestBody UserDetailsRequestModel requestUserDetails) {
		Usuarios user = usuarioServiceImpl.usuarioById(id);

		if (user != null) {
			String targetUserEmail = usuarioServiceImpl.usuarioById(id).getEmail();
			String authedUserEmail = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
					.getEmail();

			Set<Role> userRoles = ((Usuarios) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
					.getRoles();

			HashSet<String> userRolesArray = new HashSet<String>(userRoles.size());

			// Map each role name to a Strings HashSet
			for (Role role : userRoles) {
				userRolesArray.add(role.toString());
			}

			if (targetUserEmail.equals(authedUserEmail) || userRolesArray.contains("ROLE_ADMIN") == true) {
				String encoded = bCryptPasswordEncoder.encode(requestUserDetails.getPassword());

				user.setUsername(requestUserDetails.getUsername());
				user.setEmail(requestUserDetails.getEmail());
				user.setPassword(encoded);

				usuarioServiceImpl.updateUsuario(user);

				return new ResponseEntity<Object>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("You are not authorized to edit other user\'s acounts",
						HttpStatus.UNAUTHORIZED);
			}
		}

		return new ResponseEntity<Object>("The specified user doesn\'t exist in the database, try registering it",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * The user will have to login again (JWT Bearer Token is invalid)
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarUsuario(@PathVariable(name = "id") Long id) {
		Usuarios user = usuarioServiceImpl.usuarioById(id);
		JsonObject json = new JsonObject();

		if (user != null) {
			usuarioServiceImpl.deleteUsuario(id);
			json.addProperty("msg", "User deleted successfully");
			return new ResponseEntity<String>(this.gson.toJson(json), HttpStatus.OK);
		}

		json.addProperty("msg", "Error deleting the user");
		return new ResponseEntity<String>(this.gson.toJson(json), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
