package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IGrupoPlantillaDAO;
import com.easytemplates.backend.dto.GruposPlantillas;

@Service
public class GrupoPlantillaServiceImpl implements GrupoPlantillaService {

	@Autowired
	IGrupoPlantillaDAO iGrupoPlantillaDAO;

	@Override
	public List<GruposPlantillas> listAllGruposPlantillas() {
		// TODO Auto-generated method stub
		return iGrupoPlantillaDAO.findAll();
	}

	@Override
	public GruposPlantillas saveGruposPlantillas(GruposPlantillas grupo_plantillas) {
		// TODO Auto-generated method stub
		return iGrupoPlantillaDAO.save(grupo_plantillas);
	}

	@Override
	public GruposPlantillas gruposPlantillasById(Long id) {
		// TODO Auto-generated method stub
		return iGrupoPlantillaDAO.findById(id).get();
	}

	@Override
	public GruposPlantillas updateGruposPlantillas(GruposPlantillas grupo_plantilla) {
		// TODO Auto-generated method stub
		return iGrupoPlantillaDAO.save(grupo_plantilla);
	}

	@Override
	public void deleteGruposPlantillas(Long id) {
		iGrupoPlantillaDAO.deleteById(id);
	}

}
