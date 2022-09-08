package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioImagenDAO;
import com.easytemplates.backend.dto.UsuariosImagenes;
@Service
public class UsuarioImagenServiceImpl implements UsuarioImagenService{

	@Autowired
	IUsuarioImagenDAO iUsuarioImagenDAO;
	@Override
	public List<UsuariosImagenes> listAllUsuariosImagenes() {
		// TODO Auto-generated method stub
		return iUsuarioImagenDAO.findAll();
	}

	@Override
	public UsuariosImagenes saveUsuariosImagenes(UsuariosImagenes usuario_imagen) {
		// TODO Auto-generated method stub
		return iUsuarioImagenDAO.save(usuario_imagen);
	}

	@Override
	public UsuariosImagenes usuariosImagenesById(Long id) {
		// TODO Auto-generated method stub
		return iUsuarioImagenDAO.findById(id).get();
	}

	@Override
	public UsuariosImagenes updateUsuariosImagenes(UsuariosImagenes usuario_imagen) {
		// TODO Auto-generated method stub
		return iUsuarioImagenDAO.save(usuario_imagen);
	}

	@Override
	public void deleteUsuariosImagenes(Long id) {
		iUsuarioImagenDAO.deleteById(id);		
	}

	@Override
	public List<UsuariosImagenes> findByUsuario(Long id) {
		// TODO Auto-generated method stub
		return iUsuarioImagenDAO.findByUsuario(id);
	}

}
