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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.dto.UsuariosPertenecenGrupos;
import com.easytemplates.backend.service.UsuarioPerteneceGruposServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioPerteneceGruposController {

	@Autowired
	UsuarioPerteneceGruposServiceImpl usuario_gruposServiceImpl;

	@GetMapping("/usario_grupos")
	public List<UsuariosPertenecenGrupos> listarUsuarioPerteneceGrupos() {
		return usuario_gruposServiceImpl.listAllUsuarioPerteneceGrupos();
	}

	@PostMapping("/usario_grupos")
	public UsuariosPertenecenGrupos salvarUsuarioPerteneceGrupos(@RequestBody UsuariosPertenecenGrupos usario_grupos) {

		return usuario_gruposServiceImpl.saveUsuarioPerteneceGrupos(usario_grupos);
	}

	@GetMapping("/usario_grupos/{id}")
	public UsuariosPertenecenGrupos usuario_gruposXID(@PathVariable(name = "id") Long id) {

		return usuario_gruposServiceImpl.usuarioPerteneceGruposById(id);
	}
	@GetMapping("/usuarios_grupos/{nombre}")
	public List<Usuarios> usuarioXGrupo( @PathVariable(name = "nombre") String grupo_nombre) {

		return usuario_gruposServiceImpl.usuariosByGrupo(grupo_nombre);
	}
	

	@PutMapping("/usario_grupos/{id}")
	public UsuariosPertenecenGrupos actualizarUsuarioPerteneceGrupos(@PathVariable(name = "id") Long id,
			@RequestBody UsuariosPertenecenGrupos usuario_grupos) {

		UsuariosPertenecenGrupos seleccionado = new UsuariosPertenecenGrupos();
		UsuariosPertenecenGrupos actualizado = new UsuariosPertenecenGrupos();

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