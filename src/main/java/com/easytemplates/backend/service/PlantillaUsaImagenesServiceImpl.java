package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.easytemplates.backend.dao.IPlantillaUsaImagenesDAO;
import com.easytemplates.backend.dto.PlantillaUsaImagenes;

public class PlantillaUsaImagenesServiceImpl implements IPlantillaUsaImagenesService {

	@Autowired
	IPlantillaUsaImagenesDAO puiDao;

	@Override
	public List<PlantillaUsaImagenes> listPlantillaUsaImagenes() {
		return puiDao.findAll();
	}

	@Override
	public PlantillaUsaImagenes plantillasUsanImagenesXID(Long id) {
		return puiDao.findById(id).get();
	}

	@Override
	public PlantillaUsaImagenes savePlantillaUsaImagenes(PlantillaUsaImagenes plantillasUsanImagenes) {
		return puiDao.save(plantillasUsanImagenes);
	}

	@Override
	public PlantillaUsaImagenes updatePlantillaUsaImagenes(PlantillaUsaImagenes plantillasUsanImagenes) {
		return puiDao.save(plantillasUsanImagenes);
	}

	@Override
	public String deletePlantillaUsaImagenes(Long id) {
		puiDao.deleteById(id);
		return "Plantilla usa imagen " + id + " eliminada";
	}
	
}
