package com.easytemplates.backend.service;

import java.util.List;

import com.easytemplates.backend.dto.GruposPlantillas;

public interface GrupoPlantillaService {
	public List<GruposPlantillas> listAllGruposPlantillas();

	public GruposPlantillas saveGruposPlantillas(GruposPlantillas grupo_plantillas);

	public GruposPlantillas gruposPlantillasById(Long id);

	public GruposPlantillas updateGruposPlantillas(GruposPlantillas grupo_plantilla);

	public void deleteGruposPlantillas(Long id);
}
