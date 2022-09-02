package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Plantillas;

public interface IPlantillaService {

	public List<Plantillas> listPlantillas();
	
	public Plantillas plantillaXID(Long id);
	
	public Plantillas savePlantilla(Plantillas plantilla);
	
	public Plantillas updatePlantila(Plantillas plantilla);
	
	public String deletePlantilla(Long id);
	
}
