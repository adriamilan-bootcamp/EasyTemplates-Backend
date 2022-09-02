package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IPlantillaUsaImagenesDAO;
import com.easytemplates.backend.dto.PlantillasUsanImagenes;
@Service
public class PlantillaUsaImagenesServiceImpl implements IPlantillaUsaImagenesService {

	@Autowired
	IPlantillaUsaImagenesDAO puiDao;

	@Override
	public List<PlantillasUsanImagenes> listPlantillaUsaImagenes() {
		return puiDao.findAll();
	}

	@Override
	public PlantillasUsanImagenes plantillasUsanImagenesXID(Long id) {
		return puiDao.findById(id).get();
	}

	@Override
	public PlantillasUsanImagenes savePlantillaUsaImagenes(PlantillasUsanImagenes plantillasUsanImagenes) {
		return puiDao.save(plantillasUsanImagenes);
	}

	@Override
	public PlantillasUsanImagenes updatePlantillaUsaImagenes(PlantillasUsanImagenes plantillasUsanImagenes) {
		return puiDao.save(plantillasUsanImagenes);
	}

	@Override
	public String deletePlantillaUsaImagenes(Long id) {
		puiDao.deleteById(id);
		return "Plantilla usa imagen " + id + " eliminada";
	}
	
}
