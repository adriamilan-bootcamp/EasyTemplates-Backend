package com.easytemplates.backend.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/usuarios_imagenes/{id}")
	public String usuariosImagenesXID(@PathVariable(name = "id") Long id) {
		List<UsuariosImagenes> user = serviceDAO.findImagenByUsuarioId(id);
		
		// JSON Object
				JsonObject json = new JsonObject();

		for (int i = 0; i < user.size(); i++) {
		    System.out.println(user.get(i).getImagenes());
		}
					
		HashSet<String> lista = new HashSet<String>();
		
        for (int i = 0; i < user.size(); i++) {
        	lista.add(user.get(i).getImagenes().getSrc());
        }
	
		String userJsonString = this.gson.toJson(lista);
		
		
		return userJsonString;
	}

	@PutMapping("/usuarios_imagenes/{id}")
	public UsuariosImagenes actualizarUsuariosImagenes(@PathVariable(name = "id") Long id, @RequestBody UsuariosImagenes usuario_imagen) {

		UsuariosImagenes seleccionado = new UsuariosImagenes();
		UsuariosImagenes actualizado = new UsuariosImagenes();

		seleccionado = serviceImpl.usuariosImagenesById(id);

		seleccionado.setUsuario(usuario_imagen.getUsuario());
		seleccionado.setImagenes(usuario_imagen.getImagenes());
		
		

		actualizado = serviceImpl.updateUsuariosImagenes(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/usuarios_imagenes/{id}")

	public void eliminarUsuariosImagenes(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteUsuariosImagenes(id);
	}
	
}
