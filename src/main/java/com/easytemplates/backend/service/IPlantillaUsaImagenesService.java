package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.PlantillaUsaImagenes;

public interface IPlantillaUsaImagenesService {

	public List<PlantillaUsaImagenes> listPlantillaUsaImagenes();
	
	public PlantillaUsaImagenes plantillasUsanImagenesXID(Long id);
	
	public PlantillaUsaImagenes savePlantillaUsaImagenes(PlantillaUsaImagenes plantillasUsanImagenes);
	
	public PlantillaUsaImagenes updatePlantillaUsaImagenes(PlantillaUsaImagenes plantillasUsanImagenes);
	
	public String deletePlantillaUsaImagenes(Long id);
	
}
