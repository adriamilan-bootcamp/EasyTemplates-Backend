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

import com.easytemplates.backend.dto.UsuarioPerteneceGrupos;
import com.easytemplates.backend.service.UsuarioPerteneceGruposServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioPerteneceGruposController {

	@Autowired
	UsuarioPerteneceGruposServiceImpl usuario_gruposServiceImpl;

	@GetMapping("/usario_grupos")
	public List<UsuarioPerteneceGrupos> listarUsuarioPerteneceGrupos() {
		return usuario_gruposServiceImpl.listAllUsuarioPerteneceGrupos();
	}

	@PostMapping("/usario_grupos")
	public UsuarioPerteneceGrupos salvarUsuarioPerteneceGrupos(@RequestBody UsuarioPerteneceGrupos usario_grupos) {

		return usuario_gruposServiceImpl.saveUsuarioPerteneceGrupos(usario_grupos);
	}

	@GetMapping("/usario_grupos/{id}")
	public UsuarioPerteneceGrupos usuario_gruposXID(@PathVariable(name = "id") Long id) {

		return usuario_gruposServiceImpl.usuarioPerteneceGruposById(id);
	}

	@PutMapping("/usario_grupos/{id}")
	public UsuarioPerteneceGrupos actualizarUsuarioPerteneceGrupos(@PathVariable(name = "id") Long id,
			@RequestBody UsuarioPerteneceGrupos usuario_grupos) {

		UsuarioPerteneceGrupos seleccionado = new UsuarioPerteneceGrupos();
		UsuarioPerteneceGrupos actualizado = new UsuarioPerteneceGrupos();

		seleccionado = usuario_gruposServiceImpl.usuarioPerteneceGruposById(id);

		seleccionado.setUsuarios(usuario_grupos.getUsuarios());
		seleccionado.setGrupos(usuario_grupos.getGrupos());

		actualizado = usuario_gruposServiceImpl.updateUsuarioPerteneceGrupos(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/usario_grupos/{id}")

	public void eliminarUsuarioPerteneceGrupos(@PathVariable(name = "id") Long id) {
		usuario_gruposServiceImpl.deleteUsuarioPerteneceGrupos(id);
	}
}