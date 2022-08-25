package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.PlantillasUsanImagenes;

public interface IPlantillasUsanImagenesService {

	public List<PlantillasUsanImagenes> listPlantillasUsanImagenes();
	
	public PlantillasUsanImagenes plantillasUsanImagenesXID(Long id);
	
	public PlantillasUsanImagenes savePlantillasUsanImagenes(PlantillasUsanImagenes plantillasUsanImagenes);
	
	public PlantillasUsanImagenes updatePlantillasUsanImagenes(PlantillasUsanImagenes plantillasUsanImagenes);
	
	public String deletePlantillasUsanImagenes(Long id);
	
}
