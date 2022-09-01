package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.GruposImagenes;

public interface GrupoImagenService {
public List<GruposImagenes> listAllGruposImagenes();
	
	
	public GruposImagenes saveGruposImagenes(GruposImagenes grupo_imagen);
	
	
	public GruposImagenes gruposImagenesById(Long id);
	
	public GruposImagenes updateGruposImagenes(GruposImagenes grupo_imagen);
	
	public void deleteGruposImagenes(Long id);
}
