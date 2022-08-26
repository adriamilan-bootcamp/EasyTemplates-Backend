package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.Plantilla;

public interface IPlantillaService {

	public List<Plantilla> listPlantillas();
	
	public Plantilla plantillaXID(Long id);
	
	public Plantilla savePlantilla(Plantilla plantilla);
	
	public Plantilla updatePlantila(Plantilla plantilla);
	
	public String deletePlantilla(Long id);
	
}
