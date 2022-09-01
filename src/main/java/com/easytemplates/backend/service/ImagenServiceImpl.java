package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IImagenDAO;
import com.easytemplates.backend.dto.Imagenes;
@Service
public class ImagenServiceImpl implements IImagenService {
	
	@Autowired
	IImagenDAO imagenDAO;

	@Override
	public List<Imagenes> listImagenes() {
		return imagenDAO.findAll();
	}

	@Override
	public Imagenes imagenXID(Long id) {
		return imagenDAO.findById(id).get();
	}

	@Override
	public Imagenes saveImagen(Imagenes imagen) {
		return imagenDAO.save(imagen);
	}

	@Override
	public Imagenes updateImagen(Imagenes imagen) {
		return imagenDAO.save(imagen);
	}

	@Override
	public String deleteImagen(Long id) {
		imagenDAO.deleteById(id);
		return "Imagen " + id + " eliminada";
	}
	
	
	
}
