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

import com.easytemplates.backend.dto.Plantillas;
import com.easytemplates.backend.service.PlantillaServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class PlantillaController {

	@Autowired
	PlantillaServiceImpl plantillaService;
	
	private Gson gson = new Gson();
	
	@GetMapping(value = "/plantillas", produces = MediaType.APPLICATION_JSON_VALUE)
	public String listImagenes() {
		List<Plantillas> plant = plantillaService.listPlantillas();
		
		JsonObject json = new JsonObject();
		JsonArray   array   = new JsonArray ();

		for (int i = 0; i < plant.size(); i++) {
			json.addProperty("id", plant.get(i).getId().toString());
			json.addProperty("src", plant.get(i).getSrc().toString());
			json.addProperty("date", plant.get(i).getFechaCreacion().toString());
			array.add(gson.toJsonTree(json));
		}

		String userJsonString = this.gson.toJson(array);

		return userJsonString;
	} 
	
	@GetMapping("/plantilla/{id}")
	public Plantillas plantillaXID(@PathVariable(name="id") Long id) {
		return plantillaService.plantillaXID(id);
	}
	
	@PostMapping("/plantilla") 
	public Plantillas savePlantilla(@RequestBody Plantillas plantilla) {
		return plantillaService.savePlantilla(plantilla);
	}
	
	@PutMapping("/plantilla/{id}")
	public Plantillas updatePlantilla(@PathVariable(name="id") Long id, @RequestBody Plantillas plantilla) {
		Plantillas plantillaSelected = new Plantillas();
		Plantillas plantillaUpdated = new Plantillas();
		
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
