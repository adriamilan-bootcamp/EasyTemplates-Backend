package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IGrupoPdfDAO;
import com.easytemplates.backend.dto.GruposPdfs;

@Service
public class GrupoPdfServiceImpl implements GrupoPdfService {

	@Autowired
	IGrupoPdfDAO iGrupoPdfDAO;

	@Override
	public List<GruposPdfs> listAllGruposPdfs() {
		// TODO Auto-generated method stub
		return iGrupoPdfDAO.findAll();
	}

	@Override
	public GruposPdfs saveGruposPdfs(GruposPdfs grupo_pdf) {
		// TODO Auto-generated method stub
		return iGrupoPdfDAO.save(grupo_pdf);
	}

	@Override
	public GruposPdfs gruposPdfsById(Long id) {
		// TODO Auto-generated method stub
		return iGrupoPdfDAO.findById(id).get();
	}

	@Override
	public GruposPdfs updateGruposPdfs(GruposPdfs grupo_pdf) {
		// TODO Auto-generated method stub
		return iGrupoPdfDAO.save(grupo_pdf);
	}

	@Override
	public void deleteGruposPdfs(Long id) {
		iGrupoPdfDAO.deleteById(id);
	}

}
