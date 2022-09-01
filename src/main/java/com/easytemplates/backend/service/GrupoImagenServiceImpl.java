package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IGrupoImagenDAO;
import com.easytemplates.backend.dto.GruposImagenes;
@Service
public class GrupoImagenServiceImpl implements GrupoImagenService{

	@Autowired
	IGrupoImagenDAO iGrupoImagenDAO;
	@Override
	public List<GruposImagenes> listAllGruposImagenes() {
		// TODO Auto-generated method stub
		return iGrupoImagenDAO.findAll();
	}

	@Override
	public GruposImagenes saveGruposImagenes(GruposImagenes grupo_imagen) {
		// TODO Auto-generated method stub
		return iGrupoImagenDAO.save(grupo_imagen);
	}

	@Override
	public GruposImagenes gruposImagenesById(Long id) {
		// TODO Auto-generated method stub
		return iGrupoImagenDAO.findById(id).get();
	}

	@Override
	public GruposImagenes updateGruposImagenes(GruposImagenes grupo_imagen) {
		// TODO Auto-generated method stub
		return iGrupoImagenDAO.save(grupo_imagen);
	}

	@Override
	public void deleteGruposImagenes(Long id) {
		iGrupoImagenDAO.deleteById(id);		
	}

}
