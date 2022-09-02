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

import com.easytemplates.backend.dto.GruposImagenes;
import com.easytemplates.backend.service.GrupoImagenServiceImpl;

@RestController
@RequestMapping("/api")
public class GrupoImagenController {
	@Autowired
	GrupoImagenServiceImpl serviceImpl;
	
	@GetMapping("/grupos_imagenes")
	public List<GruposImagenes> listarGruposImagenes() {
		return serviceImpl.listAllGruposImagenes();
	}

	@PostMapping("/grupos_imagenes")
	public GruposImagenes salvarGruposImagenes(@RequestBody GruposImagenes grupo_imagen) {

		return serviceImpl.saveGruposImagenes(grupo_imagen);
	}

	@GetMapping("/grupos_imagenes/{id}")
	public GruposImagenes gruposImagenesXID(@PathVariable(name = "id") Long id) {

		return serviceImpl.gruposImagenesById(id);
	}

	@PutMapping("/grupos_imagenes/{id}")
	public GruposImagenes actualizarGruposImagenes(@PathVariable(name = "id") Long id, @RequestBody GruposImagenes grupo_imagen) {

		GruposImagenes seleccionado = new GruposImagenes();
		GruposImagenes actualizado = new GruposImagenes();

		seleccionado = serviceImpl.gruposImagenesById(id);

		seleccionado.setGrupos(grupo_imagen.getGrupos());
		seleccionado.setImagenes(grupo_imagen.getImagenes());
		
		

		actualizado = serviceImpl.updateGruposImagenes(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/grupos_imagenes/{id}")

	public void eliminarGruposImagenes(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteGruposImagenes(id);
	}
}
