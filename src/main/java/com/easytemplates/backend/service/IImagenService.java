package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Imagenes;

public interface IImagenService {

	public List<Imagenes> listImagenes();
	
	public Imagenes imagenXID(Long id);
	
	public Imagenes saveImagen(Imagenes imagen);
	
	public Imagenes updateImagen(Imagenes imagen);
	
	public String deleteImagen(Long id);
	
}
 