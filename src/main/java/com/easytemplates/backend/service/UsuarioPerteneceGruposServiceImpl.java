package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioPerteneceGruposDAO;
import com.easytemplates.backend.dto.UsuarioPerteneceGrupos;

@Service
public class UsuarioPerteneceGruposServiceImpl implements IUsuarioPerteneceGruposService{

	@Autowired
	IUsuarioPerteneceGruposDAO usuarioPerteneceGrupoDAO;
	
	@Override
	public List<UsuarioPerteneceGrupos> listAllUsuarioPerteneceGrupos() {
		return usuarioPerteneceGrupoDAO.findAll();
	}

	@Override
	public UsuarioPerteneceGrupos saveUsuarioPerteneceGrupos(UsuarioPerteneceGrupos usuarioPerteneceGrupos) {
		return usuarioPerteneceGrupoDAO.save(usuarioPerteneceGrupos);
	}

	@Override
	public UsuarioPerteneceGrupos usuarioPerteneceGruposById(Long id) {
		return usuarioPerteneceGrupoDAO.findById(id).get();
	}

	@Override
	public UsuarioPerteneceGrupos updateUsuarioPerteneceGrupos(UsuarioPerteneceGrupos usuarioPerteneceGrupo) {
		return usuarioPerteneceGrupoDAO.save(usuarioPerteneceGrupo);
	}

	@Override
	public void deleteUsuarioPerteneceGrupos(Long id) {
		usuarioPerteneceGrupoDAO.deleteById(id);		
	}
	
}