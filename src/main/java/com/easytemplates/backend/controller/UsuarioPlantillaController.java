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

import com.easytemplates.backend.dao.IUsuarioPlantillaDAO;
import com.easytemplates.backend.dto.UsuariosPlantillas;
import com.easytemplates.backend.service.UsuarioPlantillaServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class UsuarioPlantillaController {
	@Autowired
	UsuarioPlantillaServiceImpl serviceImpl;
	
	@Autowired
	IUsuarioPlantillaDAO serviceDAO;

	private Gson gson = new Gson();
	
	@GetMapping("/usuarios_plantillas")
	public List<UsuariosPlantillas> listarUsuariosPlantillas() {
		return serviceImpl.listAllUsuariosPlantillas();
	}

	@PostMapping("/usuarios_plantillas")
	public UsuariosPlantillas salvarUsuariosPlantillas(@RequestBody UsuariosPlantillas usuario_plantilla) {

		return serviceImpl.saveUsuariosPlantillas(usuario_plantilla);
	}

	@GetMapping(value = "/usuarios_plantillas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String usuariosPlantillasXID(@PathVariable(name = "id") Long id) {
		List<UsuariosPlantillas> user = serviceDAO.findPlantillasByUsuariosId(id);
		
		JsonObject json = new JsonObject();
		JsonArray   array   = new JsonArray ();

		for (int i = 0; i < user.size(); i++) {
			json.addProperty("id", user.get(i).getPlantillas().getId().toString());
			json.addProperty("src", user.get(i).getPlantillas().getSrc().toString());
			json.addProperty("titulo", user.get(i).getPlantillas().getTitulo().toString());
			json.addProperty("fechaCreacion", user.get(i).getPlantillas().getFechaCreacion().toString());
			array.add(gson.toJsonTree(json));
		}

		String userJsonString = this.gson.toJson(array);

		return userJsonString;
	}

	@PutMapping("/usuarios_plantillas/{id}")
	public UsuariosPlantillas actualizarUsuariosPlantillas(@PathVariable(name = "id") Long id, @RequestBody UsuariosPlantillas usuario_plantilla) {

		UsuariosPlantillas seleccionado = new UsuariosPlantillas();
		UsuariosPlantillas actualizado = new UsuariosPlantillas();

		seleccionado = serviceImpl.usuariosPlantillasById(id);

		seleccionado.setUsuarios(usuario_plantilla.getUsuarios());
		seleccionado.setPlantillas(usuario_plantilla.getPlantillas());
		
		

		actualizado = serviceImpl.updateUsuariosPlantillas(seleccionado);

		return actualizado;
	}

	@DeleteMapping(value = "/usuarios_plantillas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String eliminarUsuariosImagenes(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteUsuariosPlantillas(id);
		
		JsonObject json = new JsonObject();
		json.addProperty("msg", "User's template deleted successfully!");
		
		return this.gson.toJson(json);
	}
}
