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

import com.easytemplates.backend.dto.GruposPlantillas;
import com.easytemplates.backend.service.GrupoPlantillaServiceImpl;



@RestController
@RequestMapping("/api")
public class GrupoPlantillaController {
	@Autowired
	GrupoPlantillaServiceImpl serviceImpl;
	
	@GetMapping("/grupos_plantillas")
	public List<GruposPlantillas> listarGruposPlantillas() {
		return serviceImpl.listAllGruposPlantillas();
	}

	@PostMapping("/grupos_plantillas")
	public GruposPlantillas salvarGruposPlantillas(@RequestBody GruposPlantillas grupo_plantilla) {

		return serviceImpl.saveGruposPlantillas(grupo_plantilla);
	}

	@GetMapping("/grupos_plantillas/{id}")
	public GruposPlantillas gruposPlantillasXID(@PathVariable(name = "id") Long id) {

		return serviceImpl.gruposPlantillasById(id);
	}

	@PutMapping("/grupos_plantillas/{id}")
	public GruposPlantillas actualizarGruposPlantillas(@PathVariable(name = "id") Long id, @RequestBody GruposPlantillas grupo_plantilla) {

		GruposPlantillas seleccionado = new GruposPlantillas();
		GruposPlantillas actualizado = new GruposPlantillas();

		seleccionado = serviceImpl.gruposPlantillasById(id);

		seleccionado.setGrupos(grupo_plantilla.getGrupos());
		seleccionado.setPlantillas(grupo_plantilla.getPlantillas());
		
		

		actualizado = serviceImpl.updateGruposPlantillas(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/grupos_plantillas/{id}")

	public void eliminarGruposPlantillas(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteGruposPlantillas(id);
	}
}
