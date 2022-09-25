package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dao.IUsuarioImagenDAO;
import com.easytemplates.backend.dto.UsuariosImagenes;
import com.easytemplates.backend.service.UsuarioImagenServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class UsuarioImagenController {

	@Autowired
	UsuarioImagenServiceImpl serviceImpl;
	
	@Autowired
	IUsuarioImagenDAO serviceDAO;

	private Gson gson = new Gson();
	
	@GetMapping("/usuarios_imagenes")
	public List<UsuariosImagenes> listarUsuariosImagenes() {
		return serviceImpl.listAllUsuariosImagenes();
	}

	@PostMapping("/usuarios_imagenes")
	public UsuariosImagenes salvarUsuariosImagenes(@RequestBody UsuariosImagenes usuario_imagen) {

		return serviceImpl.saveUsuariosImagenes(usuario_imagen);
	}

	@GetMapping(value = "/usuarios_imagenes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String usuariosImagenesXID(@PathVariable(name = "id") Long id) {
		List<UsuariosImagenes> user = serviceDAO.findImagenByUsuarioId(id);

		
		JsonObject json = new JsonObject();
		JsonArray   array   = new JsonArray ();

		for (int i = 0; i < user.size(); i++) {
			json.addProperty("id", user.get(i).getId().toString());
			json.addProperty("src", user.get(i).getImagenes().getSrc().toString());
			json.addProperty("date", user.get(i).getImagenes().getFechaCreacion().toString());
			array.add(gson.toJsonTree(json));
		}

		String userJsonString = this.gson.toJson(array);

		return userJsonString;
		
		
	}

	@PutMapping("/usuarios_imagenes/{id}")
	public UsuariosImagenes actualizarUsuariosImagenes(@PathVariable(name = "id") Long id, @RequestBody UsuariosImagenes usuario_imagen) {

		UsuariosImagenes seleccionado = new UsuariosImagenes();
		UsuariosImagenes actualizado = new UsuariosImagenes();

		seleccionado = serviceImpl.usuariosImagenesByIdUsuario(id);

		seleccionado.setUsuario(usuario_imagen.getUsuario());
		seleccionado.setImagenes(usuario_imagen.getImagenes());
		
		

		actualizado = serviceImpl.updateUsuariosImagenes(seleccionado);

		return actualizado;
	}
	
	@DeleteMapping(value = "/usuarios_imagenes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String eliminarUsuariosPdfs(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteUsuariosImagenes(id);
		
		JsonObject json = new JsonObject();
		json.addProperty("msg", "User's image deleted successfully!");
		
		return this.gson.toJson(json);
	}
}
