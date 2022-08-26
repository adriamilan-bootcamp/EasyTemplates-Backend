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

import com.easytemplates.backend.dto.PlantillaUsaImagenes;
import com.easytemplates.backend.service.IPlantillaUsaImagenesService;

@RestController
@RequestMapping("/api")
public class PlantillaUsaImagenesController {

	@Autowired
	IPlantillaUsaImagenesService puiService;
	
	@GetMapping("/plantillasusanimagenes")
	public List<PlantillaUsaImagenes> listPUIs() {
		return puiService.listPlantillaUsaImagenes();
	}
	
	@GetMapping("/plantillasusanimagenes/{id}")
	public PlantillaUsaImagenes puiXID(@PathVariable(name="id") Long id) {
		return puiService.plantillasUsanImagenesXID(id);
	}
	
	@PostMapping("/plantillasusanimagenes")
	public PlantillaUsaImagenes savePUI(@RequestBody PlantillaUsaImagenes plantillasUsanImagenes) {
		return puiService.savePlantillaUsaImagenes(plantillasUsanImagenes);
	}
	
	@PutMapping("/plantillasusanimagenes/{id}")
	public PlantillaUsaImagenes updatePUI(@PathVariable(name="id") Long id, @RequestBody PlantillaUsaImagenes plantillasUsanImagenes) {
		PlantillaUsaImagenes puiSelected = new PlantillaUsaImagenes();
		PlantillaUsaImagenes puiUpdated = new PlantillaUsaImagenes();
		
		puiSelected = puiService.plantillasUsanImagenesXID(id);
		puiSelected.setImagen(plantillasUsanImagenes.getImagen());
		puiSelected.setPlantilla(plantillasUsanImagenes.getPlantilla());
		
		puiUpdated = puiService.updatePlantillaUsaImagenes(puiSelected);
		
		return puiUpdated;
	}
	
	@DeleteMapping("/plantillasusanimagenes/{id}")
	public String deletePUI(@PathVariable(name="id") Long id) {
		return puiService.deletePlantillaUsaImagenes(id);
	}
	
}
