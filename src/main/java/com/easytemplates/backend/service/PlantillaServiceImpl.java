package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.easytemplates.backend.dao.IPlantillaDAO;
import com.easytemplates.backend.dto.Plantilla;

public class PlantillaServiceImpl implements IPlantillaService {

	@Autowired
	IPlantillaDAO plantillaDAO;
	
	@Override
	public List<Plantilla> listPlantillas() {
		return plantillaDAO.findAll();
	}

	@Override
	public Plantilla plantillaXID(Long id) {
		return plantillaDAO.findById(id).get();
	}

	@Override
	public Plantilla savePlantilla(Plantilla plantilla) {
		return plantillaDAO.save(plantilla);
	}

	@Override
	public Plantilla updatePlantila(Plantilla plantilla) {
		return plantillaDAO.save(plantilla);
	}

	@Override
	public String deletePlantilla(Long id) {
		plantillaDAO.deleteById(id);
		return "Plantilla " + id + " eliminada";
	}

}
