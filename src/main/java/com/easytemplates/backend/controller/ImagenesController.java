package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public ResponseEntity<String> uploadFile(@RequestPart(value="file") MultipartFile file) throws Exception {
		imagenService.uploadFile(file);
		String response = "El archivo " + file.getOriginalFilename() + " fue subido correctamente a s3";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/imagen/{id}")
	public String deleteImagen(@PathVariable(name="id") Long id) {
		return imagenService.deleteImagen(id);
	}
	
}
