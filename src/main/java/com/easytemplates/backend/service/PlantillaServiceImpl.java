package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IPlantillaDAO;
import com.easytemplates.backend.dto.Plantillas;
@Service
public class PlantillaServiceImpl implements IPlantillaService {

	@Autowired
	IPlantillaDAO plantillaDAO;
	
	@Override
	public List<Plantillas> listPlantillas() {
		return plantillaDAO.findAll();
	}

	@Override
	public Plantillas plantillaXID(Long id) {
		return plantillaDAO.findById(id).get();
	}

	@Override
	public Plantillas savePlantilla(Plantillas plantilla) {
		return plantillaDAO.save(plantilla);
	}

	@Override
	public Plantillas updatePlantila(Plantillas plantilla) {
		return plantillaDAO.save(plantilla);
	}

	@Override
	public String deletePlantilla(Long id) {
		plantillaDAO.deleteById(id);
		return "Plantilla " + id + " eliminada";
	}

}
