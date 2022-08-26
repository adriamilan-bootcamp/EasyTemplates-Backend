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

import com.easytemplates.backend.dto.PlantillasUsanImagenes;
import com.easytemplates.backend.service.IPlantillasUsanImagenesService;

@RestController
@RequestMapping("/api")
public class PlantillasUsanImagenesController {

	@Autowired
	IPlantillasUsanImagenesService puiService;
	
	@GetMapping("/plantillasusanimagenes")
	public List<PlantillasUsanImagenes> listPUIs() {
		return puiService.listPlantillasUsanImagenes();
	}
	
	@GetMapping("/plantillasusanimagenes/{id}")
	public PlantillasUsanImagenes puiXID(@PathVariable(name="id") Long id) {
		return puiService.plantillasUsanImagenesXID(id);
	}
	
	@PostMapping("/plantillasusanimagenes")
	public PlantillasUsanImagenes savePUI(@RequestBody PlantillasUsanImagenes plantillasUsanImagenes) {
		return puiService.savePlantillasUsanImagenes(plantillasUsanImagenes);
	}
	
	@PutMapping("/plantillasusanimagenes/{id}")
	public PlantillasUsanImagenes updatePUI(@PathVariable(name="id") Long id, @RequestBody PlantillasUsanImagenes plantillasUsanImagenes) {
		PlantillasUsanImagenes puiSelected = new PlantillasUsanImagenes();
		PlantillasUsanImagenes puiUpdated = new PlantillasUsanImagenes();
		
		puiSelected = puiService.plantillasUsanImagenesXID(id);
		puiSelected.setImagen(plantillasUsanImagenes.getImagen());
		puiSelected.setPlantilla(plantillasUsanImagenes.getPlantilla());
		
		puiUpdated = puiService.updatePlantillasUsanImagenes(puiSelected);
		
		return puiUpdated;
	}
	
	@DeleteMapping("/plantillasusanimagenes/{id}")
	public String deletePUI(@PathVariable(name="id") Long id) {
		return puiService.deletePlantillasUsanImagenes(id);
	}
	
}