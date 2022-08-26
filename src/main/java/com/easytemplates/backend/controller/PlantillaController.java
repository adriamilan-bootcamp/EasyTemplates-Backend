package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dto.Plantilla;
import com.easytemplates.backend.service.PlantillaServiceImpl;

@RestController
@RequestMapping("/api")
public class PlantillaController {

	@Autowired
	PlantillaServiceImpl plantillaService;
	
	@GetMapping("/plantillas")
	public List<Plantilla> listPlantillas() {
		return plantillaService.listPlantillas();
	}
	
	@GetMapping("/plantilla/{id}")
	public Plantilla plantillaXID(@PathVariable(name="id") Long id) {
		return plantillaService.plantillaXID(id);
	}
	
	@PostMapping("/plantilla") 
	public Plantilla savePlantilla(@RequestBody Plantilla plantilla) {
		return plantillaService.savePlantilla(plantilla);
	}
	
	@PutMapping("/plantilla/{id}")
	public Plantilla updatePlantilla(@PathVariable(name="id") Long id, @RequestBody Plantilla plantilla) {
		Plantilla plantillaSelected = new Plantilla();
		Plantilla plantillaUpdated = new Plantilla();
		
		plantillaSelected = plantillaService.plantillaXID(id);
		plantillaSelected.setTitulo(plantilla.getTitulo());
		plantillaSelected.setSrc(plantilla.getSrc());
		
		plantillaUpdated = plantillaService.updatePlantila(plantillaSelected);
		
		return plantillaUpdated;
	}
	
	@DeleteMapping("/plantilla/{id}")
	public String deletePlantilla(@PathVariable(name="id") Long id) {
		return plantillaService.deletePlantilla(id);
	}
	
}