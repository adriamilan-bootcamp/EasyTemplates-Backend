package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioPerteneceGruposDAO;
import com.easytemplates.backend.dto.UsuariosPertenecenGrupos;

@Service
public class UsuarioPerteneceGruposServiceImpl implements IUsuarioPerteneceGruposService{

	@Autowired
	IUsuarioPerteneceGruposDAO usuarioPerteneceGrupoDAO;
	
	@Override
	public List<UsuariosPertenecenGrupos> listAllUsuarioPerteneceGrupos() {
		return usuarioPerteneceGrupoDAO.findAll();
	}

	@Override
	public UsuariosPertenecenGrupos saveUsuarioPerteneceGrupos(UsuariosPertenecenGrupos usuarioPerteneceGrupos) {
		return usuarioPerteneceGrupoDAO.save(usuarioPerteneceGrupos);
	}

	@Override
	public UsuariosPertenecenGrupos usuarioPerteneceGruposById(Long id) {
		return usuarioPerteneceGrupoDAO.findById(id).get();
	}

	@Override
	public UsuariosPertenecenGrupos updateUsuarioPerteneceGrupos(UsuariosPertenecenGrupos usuarioPerteneceGrupo) {
		return usuarioPerteneceGrupoDAO.save(usuarioPerteneceGrupo);
	}

	@Override
	public void deleteUsuarioPerteneceGrupos(Long id) {
		usuarioPerteneceGrupoDAO.deleteById(id);		
	}
	
}