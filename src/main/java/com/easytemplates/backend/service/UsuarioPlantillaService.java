package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.UsuariosPlantillas;

public interface UsuarioPlantillaService {
	
	public List<UsuariosPlantillas> listAllUsuariosPlantillas();
	
	
	public UsuariosPlantillas saveUsuariosPlantillas(UsuariosPlantillas usuario_plantillas);
	
	
	public UsuariosPlantillas usuariosPlantillasById(Long id);
	
	public UsuariosPlantillas updateUsuariosPlantillas(UsuariosPlantillas usuario_plantilla);
	
	public void deleteUsuariosPlantillas(Long id);
}
