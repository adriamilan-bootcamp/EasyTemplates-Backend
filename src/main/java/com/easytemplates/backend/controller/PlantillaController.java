package com.easytemplates.backend.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.easytemplates.backend.dao.IPlantillaDAO;
import com.easytemplates.backend.dto.Plantillas;
import com.easytemplates.backend.security.SecurityLogging;
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
	
	@GetMapping("/plantilla/titulo")
	public List<Plantillas> plantillaXtitulo(@RequestParam(name = "title") String title) {
		return iPlantillaDAO.findByTitulo(title);	
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
	
	/**
	 * 	Amazon S3
	 */

	@PostMapping(value = "/plantilla", produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<String> uploadPlantilla(@RequestPart(value="file") MultipartFile file,
			@RequestParam(name = "title") String title) throws Exception {
		
			plantillaService.uploadFile(file, title);
			
			JsonObject json = new JsonObject();
			json.addProperty("msg", "El archivo " + file.getOriginalFilename() + " fue subido correctamente a s3!");
			
			return new ResponseEntity<>(this.gson.toJson(json), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/plantilla/s3/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ByteArrayResource> getTemplateFromS3(@PathVariable(name="id") Long id) {
		Plantillas plantilla = plantillaService.plantillaXID(id);
		
		String url = plantilla.getSrc();
		
		String escape = "[^/\\\\&\\?]+\\.\\w{3,4}(?=([\\?&].*$|$))";
		
		final Pattern pattern = Pattern.compile(escape, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(url);

        matcher.find();
        
        SecurityLogging.logMsg("TEMPLATE-S3", "Downloading " + matcher.group(0));
        
        byte[] data = plantillaService.downloadFile(matcher.group(0));
        ByteArrayResource resource = new ByteArrayResource(data);
        
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/json")
                .header("Content-disposition", "attachment; filename=\"" + matcher.group(0).toString() + "\"")
                .body(resource);
	}
}
