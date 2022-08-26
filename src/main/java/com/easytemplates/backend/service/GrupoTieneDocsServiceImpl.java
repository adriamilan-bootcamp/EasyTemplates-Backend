package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IGrupoTieneDocsDAO;
import com.easytemplates.backend.dto.GrupoTieneDocs;

@Service
public class GrupoTieneDocsServiceImpl implements IGrupoTieneDocsService {

	@Autowired
	IGrupoTieneDocsDAO gtdDAO;
	
	@Override
	public List<GrupoTieneDocs> listAllGrupoTieneDocs() {
		return gtdDAO.findAll();
	}

	@Override
	public GrupoTieneDocs saveGrupoTieneDocs(GrupoTieneDocs g) {
		return gtdDAO.save(g);
	}

	@Override
	public GrupoTieneDocs grupoTieneDocsById(Long id) {
		return gtdDAO.findById(id).get();
	}

	@Override
	public GrupoTieneDocs updateGrupoTieneDocs(GrupoTieneDocs g) {
		return gtdDAO.save(g);
	}

	@Override
	public void deleteGrupoTieneDocs(Long id) {
		gtdDAO.deleteById(id);
	}

}
