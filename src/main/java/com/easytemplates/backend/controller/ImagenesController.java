package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.easytemplates.backend.dto.Imagenes;
import com.easytemplates.backend.service.IImagenService;
import com.easytemplates.backend.service.UsuarioImagenServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class ImagenesController {
	
	@Autowired
	IImagenService imagenService;

	@Autowired
	UsuarioImagenServiceImpl imguserSvc;
	
	private Gson gson = new Gson();
	
	@GetMapping(value = "/imagenes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Imagenes> listImagenes() {
		return imagenService.listImagenes();
	}
	
	@GetMapping("/imagen/{id}")
	public Imagenes imagenXID(@PathVariable(name="id") Long id) {
		return imagenService.imagenXID(id);
	}
	
	@PostMapping("/imagen")
	public ResponseEntity<String> uploadFile(@RequestPart(value="file") MultipartFile file) throws Exception {
		String url = imagenService.uploadFile(file);
		JsonObject json = new JsonObject();
		json.addProperty("src", url);
		
		return new ResponseEntity<>(this.gson.toJson(json), HttpStatus.OK);
	}

	@DeleteMapping(value = "/imagen/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteImagen(@PathVariable(name = "id") Long id) {
		imagenService.deleteImagen(id);
		
		imguserSvc.deleteUsuariosImagenes(imguserSvc.findImagenById(id).getId());
		
		JsonObject json = new JsonObject();
		json.addProperty("msg", "Image deleted successfully!");
		
		return this.gson.toJson(json);
	}
}
