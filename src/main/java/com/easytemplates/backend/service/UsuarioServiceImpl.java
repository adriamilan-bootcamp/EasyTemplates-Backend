package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Usuarios;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	IUsuarioDAO usuarioDAO;

	@Override
	public List<Usuarios> listAllUsuarios() {
		return usuarioDAO.findAll();
	}

	@Override
	public Usuarios saveUsuario(Usuarios usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	public Usuarios usuarioById(Long id) {
		return usuarioDAO.findById(id).get();
	}

	@Override
	public Usuarios updateUsuario(Usuarios usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	public void deleteUsuario(Long id) {
		usuarioDAO.deleteById(id);
	}

}