package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioPdfDAO;
import com.easytemplates.backend.dto.UsuariosPdfs;
@Service
public class UsuarioPdfServiceImpl implements UsuarioPdfService{

	@Autowired
	IUsuarioPdfDAO iUsuarioPdfDAO;
	
	@Override
	public List<UsuariosPdfs> listAllUsuariosPdfs() {
		// TODO Auto-generated method stub
		return iUsuarioPdfDAO.findAll();
	}

	@Override
	public UsuariosPdfs saveUsuariosPdfs(UsuariosPdfs usuario_pdf) {
		// TODO Auto-generated method stub
		return iUsuarioPdfDAO.save(usuario_pdf);
	}

	@Override
	public UsuariosPdfs usuariosPdfsById(Long id) {
		// TODO Auto-generated method stub
		return iUsuarioPdfDAO.findById(id).get();
	}

	@Override
	public UsuariosPdfs updateUsuariosPdfs(UsuariosPdfs usuario_pdf) {
		// TODO Auto-generated method stub
		return iUsuarioPdfDAO.save(usuario_pdf);
	}

	@Override
	public void deleteUsuariosPdfs(Long id) {
		iUsuarioPdfDAO.deleteById(id);		
	}

}
