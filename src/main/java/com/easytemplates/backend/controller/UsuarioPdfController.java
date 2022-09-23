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

import com.easytemplates.backend.dao.IUsuarioPdfDAO;
import com.easytemplates.backend.dto.UsuariosPdfs;
import com.easytemplates.backend.service.UsuarioPdfServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


@RestController
@RequestMapping("/api")
public class UsuarioPdfController {
	@Autowired
	UsuarioPdfServiceImpl serviceImpl;
	
	@Autowired
	IUsuarioPdfDAO serviceDAO;

	private Gson gson = new Gson();
	
	@GetMapping("/usuarios_pdfs")
	public List<UsuariosPdfs> listarUsuariosPdfs() {
		return serviceImpl.listAllUsuariosPdfs();
	}

	@PostMapping("/usuarios_pdfs")
	public UsuariosPdfs salvarUsuariosPdfs(@RequestBody UsuariosPdfs usuario_pdf) {

		return serviceImpl.saveUsuariosPdfs(usuario_pdf);
	}

	@GetMapping(value = "/usuarios_pdfs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String usuariosPdfsXID(@PathVariable(name = "id") Long id) {
		List<UsuariosPdfs> user = serviceDAO.findPdfByUsuariosId(id);

		JsonObject json = new JsonObject();
		JsonArray   array   = new JsonArray ();

		for (int i = 0; i < user.size(); i++) {
			json.addProperty("id", String.valueOf(user.get(i).getPdfs().getId()));
			json.addProperty("src", user.get(i).getPdfs().getSrc().toString());
			json.addProperty("titulo", user.get(i).getPdfs().getTitulo().toString());
			json.addProperty("fechaCreacion", user.get(i).getPdfs().getFechaCreacion().toString());
			array.add(gson.toJsonTree(json));
		}

		String userJsonString = this.gson.toJson(array);

		return userJsonString;
	}

	@PutMapping("/usuarios_pdfs/{id}")
	public UsuariosPdfs actualizarUsuariosPdfs(@PathVariable(name = "id") Long id, @RequestBody UsuariosPdfs usuario_pdf) {

		UsuariosPdfs seleccionado = new UsuariosPdfs();
		UsuariosPdfs actualizado = new UsuariosPdfs();

		seleccionado = serviceImpl.usuariosPdfsById(id);

		seleccionado.setUsuarios(usuario_pdf.getUsuarios());
		seleccionado.setPdfs(usuario_pdf.getPdfs());
		
		

		actualizado = serviceImpl.updateUsuariosPdfs(seleccionado);

		return actualizado;
	}

	@DeleteMapping(value = "/usuarios_pdfs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String eliminarUsuariosPdfs(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteUsuariosPdfs(id);
		
		JsonObject json = new JsonObject();
		json.addProperty("msg", "User's pdf deleted successfully!");
		
		return this.gson.toJson(json);
	}
}
