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

import com.easytemplates.backend.dto.UsuariosPdfs;
import com.easytemplates.backend.service.UsuarioPdfServiceImpl;


@RestController
@RequestMapping("/api")
public class UsuarioPdfController {
	@Autowired
	UsuarioPdfServiceImpl serviceImpl;
	
	@GetMapping("/usuarios_pdfs")
	public List<UsuariosPdfs> listarUsuariosPdfs() {
		return serviceImpl.listAllUsuariosPdfs();
	}

	@PostMapping("/usuarios_pdfs")
	public UsuariosPdfs salvarUsuariosPdfs(@RequestBody UsuariosPdfs usuario_pdf) {

		return serviceImpl.saveUsuariosPdfs(usuario_pdf);
	}

	@GetMapping("/usuarios_pdfs/{id}")
	public UsuariosPdfs usuariosPdfsXID(@PathVariable(name = "id") Long id) {

		return serviceImpl.usuariosPdfsById(id);
	}

	@PutMapping("/usuarios_pdfs/{id}")
	public UsuariosPdfs actualizarUsuariosPdfs(@PathVariable(name = "id") Long id, @RequestBody UsuariosPdfs usuario_pdf) {

		UsuariosPdfs seleccionado = new UsuariosPdfs();
		UsuariosPdfs actualizado = new UsuariosPdfs();

		seleccionado = serviceImpl.usuariosPdfsById(id);

		seleccionado.setUsuarios(usuario_pdf.getUsuarios());
		seleccionado.setPdfs(usuario_pdf.getPdfs());
		
		

		actualizado = serviceImpl.updateUsuariosPdfs(seleccionado);

		return actualizado;
	}

	@DeleteMapping("/usuarios_pdfs/{id}")

	public void eliminarUsuariosImagenes(@PathVariable(name = "id") Long id) {
		serviceImpl.deleteUsuariosPdfs(id);
	}
}
