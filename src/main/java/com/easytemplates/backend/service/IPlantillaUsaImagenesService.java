package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.PlantillasUsanImagenes;

public interface IPlantillaUsaImagenesService {

	public List<PlantillasUsanImagenes> listPlantillaUsaImagenes();
	
	public PlantillasUsanImagenes plantillasUsanImagenesXID(Long id);
	
	public PlantillasUsanImagenes savePlantillaUsaImagenes(PlantillasUsanImagenes plantillasUsanImagenes);
	
	public PlantillasUsanImagenes updatePlantillaUsaImagenes(PlantillasUsanImagenes plantillasUsanImagenes);
	
	public String deletePlantillaUsaImagenes(Long id);
	
}
