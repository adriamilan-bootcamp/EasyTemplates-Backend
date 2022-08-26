package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Imagen;

public interface IImagenService {

	public List<Imagen> listImagenes();
	
	public Imagen imagenXID(Long id);
	
	public Imagen saveImagen(Imagen imagen);
	
	public Imagen updateImagen(Imagen imagen);
	
	public String deleteImagen(Long id);
	
}
