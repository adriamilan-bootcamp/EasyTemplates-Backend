package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.easytemplates.backend.dao.IImagenDAO;
import com.easytemplates.backend.dto.Imagen;

public class ImagenServiceImpl implements IImagenService {
	
	@Autowired
	IImagenDAO imagenDAO;

	@Override
	public List<Imagen> listImagenes() {
		return imagenDAO.findAll();
	}

	@Override
	public Imagen imagenXID(Long id) {
		return imagenDAO.findById(id).get();
	}

	@Override
	public Imagen saveImagen(Imagen imagen) {
		return imagenDAO.save(imagen);
	}

	@Override
	public Imagen updateImagen(Imagen imagen) {
		return imagenDAO.save(imagen);
	}

	@Override
	public String deleteImagen(Long id) {
		imagenDAO.deleteById(id);
		return "Imagen " + id + " eliminada";
	}
	
	
	
}
