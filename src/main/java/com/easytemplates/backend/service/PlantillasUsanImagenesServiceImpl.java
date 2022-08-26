package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.easytemplates.backend.dao.IPlantillasUsanImagenesDAO;
import com.easytemplates.backend.dto.PlantillasUsanImagenes;

public class PlantillasUsanImagenesServiceImpl implements IPlantillasUsanImagenesService {

	@Autowired
	IPlantillasUsanImagenesDAO puiDao;

	@Override
	public List<PlantillasUsanImagenes> listPlantillasUsanImagenes() {
		return puiDao.findAll();
	}

	@Override
	public PlantillasUsanImagenes plantillasUsanImagenesXID(Long id) {
		return puiDao.findById(id).get();
	}

	@Override
	public PlantillasUsanImagenes savePlantillasUsanImagenes(PlantillasUsanImagenes plantillasUsanImagenes) {
		return puiDao.save(plantillasUsanImagenes);
	}

	@Override
	public PlantillasUsanImagenes updatePlantillasUsanImagenes(PlantillasUsanImagenes plantillasUsanImagenes) {
		return puiDao.save(plantillasUsanImagenes);
	}

	@Override
	public String deletePlantillasUsanImagenes(Long id) {
		puiDao.deleteById(id);
		return "Plantilla usa imagen " + id + " eliminada";
	}
	
}
