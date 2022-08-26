package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IGrupoDAO;
import com.easytemplates.backend.dto.Grupo;
@Service
public class GrupoServiceImpl implements IGrupoService{

	// The DAO Handler for the operations
	@Autowired
	IGrupoDAO grupoDAO;
	
	@Override
	public List<Grupo> listAllGrupos() {
		return grupoDAO.findAll();
	}

	@Override
	public Grupo saveGrupo(Grupo grupo) {
		return grupoDAO.save(grupo);
	}

	@Override
	public Grupo gruposById(Long id) {
		return grupoDAO.findById(id).get();
	}

	@Override
	public Grupo updateGrupo(Grupo grupo) {
		return grupoDAO.save(grupo);
	}

	@Override
	public void deleteGrupo(Long id) {
		grupoDAO.deleteById(id);		
	}
	
}