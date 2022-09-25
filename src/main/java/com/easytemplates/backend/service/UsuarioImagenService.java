package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.UsuariosImagenes;

public interface UsuarioImagenService {
	
	public List<UsuariosImagenes> listAllUsuariosImagenes();
	
	public UsuariosImagenes saveUsuariosImagenes(UsuariosImagenes usuario_imagen);
	
	public UsuariosImagenes usuariosImagenesByIdUsuario(Long id);
	
	public UsuariosImagenes updateUsuariosImagenes(UsuariosImagenes usuario_imagen);
	
	public void deleteUsuariosImagenes(Long id);
}
