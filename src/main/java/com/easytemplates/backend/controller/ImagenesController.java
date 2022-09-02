package com.easytemplates.backend.controller;

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

import com.easytemplates.backend.dto.Imagenes;
import com.easytemplates.backend.service.IImagenService;

@RestController
@RequestMapping("/api")
public class ImagenesController {

	@Autowired
	IImagenService imagenService;
	
	@GetMapping("/imagenes")
	public List<Imagenes> listImagenes() {
		return imagenService.listImagenes();
	} 
	
	@GetMapping("/imagen/{id}")
	public Imagenes imagenXID(@PathVariable(name="id") Long id) {
		return imagenService.imagenXID(id);
	}
	
	@PostMapping("/imagen")
	public Imagenes saveImagen(@RequestBody Imagenes imagen) {
		return imagenService.saveImagen(imagen);
	}
	
	@PutMapping("/imagen/{id}")
	public Imagenes editImagen(@PathVariable(name="id") Long id, @RequestBody Imagenes imagen) {
		Imagenes imagenSelected = new Imagenes();
		Imagenes imagenUpdated = new Imagenes();
		
		imagenSelected = imagenService.imagenXID(id);
		imagenSelected.setSrc(imagen.getSrc());
		
		imagenUpdated = imagenService.updateImagen(imagenSelected);
		
		return imagenUpdated;
	}
	
	@DeleteMapping("/imagen/{id}")
	public String deleteImagen(@PathVariable(name="id") Long id) {
		return imagenService.deleteImagen(id);
	}
	
}
