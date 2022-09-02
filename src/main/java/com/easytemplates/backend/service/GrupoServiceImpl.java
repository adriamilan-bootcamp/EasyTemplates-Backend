package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IGrupoDAO;
import com.easytemplates.backend.dto.Grupos;
@Service
public class GrupoServiceImpl implements IGrupoService{

	// The DAO Handler for the operations
	@Autowired
	IGrupoDAO grupoDAO;
	
	@Override
	public List<Grupos> listAllGrupos() {
		return grupoDAO.findAll();
	}

	@Override
	public Grupos saveGrupo(Grupos grupo) {
		return grupoDAO.save(grupo);
	}

	@Override
	public Grupos gruposById(Long id) {
		return grupoDAO.findById(id).get();
	}

	@Override
	public Grupos updateGrupo(Grupos grupo) {
		return grupoDAO.save(grupo);
	}

	@Override
	public void deleteGrupo(Long id) {
		grupoDAO.deleteById(id);		
	}
	
}