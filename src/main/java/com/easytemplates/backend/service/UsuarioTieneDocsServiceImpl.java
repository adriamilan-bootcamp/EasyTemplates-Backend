package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.easytemplates.backend.dao.IUsuarioTieneDocsDAO;
import com.easytemplates.backend.dto.UsuarioTieneDocs;

// Implementation of the UsuarioTieneDocsService interface
public class UsuarioTieneDocsServiceImpl implements IUsuarioTieneDocsService {

	// The DAO Handler for the operations
	@Autowired
	IUsuarioTieneDocsDAO utdDAO;
	
	@Override
	public List<UsuarioTieneDocs> listAllUsuarioTieneDocs() {
		return utdDAO.findAll();
	}

	@Override
	public UsuarioTieneDocs saveUsuarioTieneDocs(UsuarioTieneDocs u) {
		return utdDAO.save(u);
	}

	@Override
	public UsuarioTieneDocs usuarioTieneDocsById(Long id) {
		return utdDAO.findById(id).get();
	}

	@Override
	public UsuarioTieneDocs updateUsuarioTieneDocs(UsuarioTieneDocs u) {
		return utdDAO.save(u);
	}

	@Override
	public void deleteUsuarioTieneDocs(Long id) {
		utdDAO.deleteById(id);
	}

}
