package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.easytemplates.backend.dto.Imagen;

public interface IImagenService {

	public List<Imagen> listImagenes();
	
	public Imagen imagenXID(Long id);
	
	public String deleteImagen(Long id);
	
	public void uploadFile(MultipartFile file);
	
}
 