package com.easytemplates.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.easytemplates.backend.dao.IPlantillaDAO;
import com.easytemplates.backend.dto.Plantillas;
import com.easytemplates.backend.service.PlantillaServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/api")
public class PlantillaController {

	@Autowired
	PlantillaServiceImpl plantillaService;
	
	@Autowired
	IPlantillaDAO iPlantillaDAO;
	
	private Gson gson = new Gson();
	
	@GetMapping(value = "/plantillas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Plantillas> listPlantillas() {
		return plantillaService.listPlantillas();
	} 
	
	@GetMapping("/plantilla/{id}")
	public Plantillas plantillaXID(@PathVariable(name="id") Long id) {
		return plantillaService.plantillaXID(id);
	}
	
	@GetMapping("/plantilla/titulo/{titulo}")
	public List<Plantillas> plantillaXtitulo(@PathVariable(name = "titulo") String titulo) {

		return iPlantillaDAO.findByTitulo(titulo);	
	}
	
	@PostMapping("/plantilla") 
	public ResponseEntity<String> uploadPlantilla(@RequestPart(value="file") MultipartFile file) throws Exception {
			plantillaService.uploadFile(file);
			String response = "El archivo " + file.getOriginalFilename() + " fue subido correctamente a s3";
			return new ResponseEntity<>(response, HttpStatus.OK);
		
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
	
	@DeleteMapping(value = "/plantilla/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletePlantilla(@PathVariable(name = "id") Long id) {
		plantillaService.deletePlantilla(id);
		
		JsonObject json = new JsonObject();
		json.addProperty("msg", "Template deleted successfully!");
		
		return this.gson.toJson(json);
	}
}
