package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dto.PlantillasUsanImagenes;
import com.easytemplates.backend.service.IPlantillaUsaImagenesService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class PlantillaUsaImagenesController {

	@Autowired
	IPlantillaUsaImagenesService puiService;
	
	private Gson gson = new Gson();
	
	@GetMapping("/plantillasusanimagenes")
	public List<PlantillasUsanImagenes> listPUIs() {
		return puiService.listPlantillaUsaImagenes();
	}
	
	@GetMapping("/plantillasusanimagenes/{id}")
	public PlantillasUsanImagenes puiXID(@PathVariable(name="id") Long id) {
		return puiService.plantillasUsanImagenesXID(id);
	}
	
	@PostMapping("/plantillasusanimagenes")
	public PlantillasUsanImagenes savePUI(@RequestBody PlantillasUsanImagenes plantillasUsanImagenes) {
		return puiService.savePlantillaUsaImagenes(plantillasUsanImagenes);
	}
	
	@PutMapping("/plantillasusanimagenes/{id}")
	public PlantillasUsanImagenes updatePUI(@PathVariable(name="id") Long id, @RequestBody PlantillasUsanImagenes plantillasUsanImagenes) {
		PlantillasUsanImagenes puiSelected = new PlantillasUsanImagenes();
		PlantillasUsanImagenes puiUpdated = new PlantillasUsanImagenes();
		
		puiSelected = puiService.plantillasUsanImagenesXID(id);
		
		puiUpdated = puiService.updatePlantillaUsaImagenes(puiSelected);
		
		return puiUpdated;
	}
	
	@DeleteMapping(value = "/plantillasusanimagenes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletePUI(@PathVariable(name = "id") Long id) {
		puiService.deletePlantillaUsaImagenes(id);
		
		JsonObject json = new JsonObject();
		json.addProperty("msg", "Template uses images relation deleted successfully!");
		
		return this.gson.toJson(json);
	}
}
