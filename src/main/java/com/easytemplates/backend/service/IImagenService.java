package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.easytemplates.backend.dto.Imagenes;

public interface IImagenService {

	public List<Imagenes> listImagenes();
	
	public Imagenes imagenXID(Long id);
	
	public String deleteImagen(Long id);
	
	public void uploadFile(MultipartFile file);
	
}