package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	IUsuarioDAO usuarioDAO;

	@Override
	public List<Usuario> listAllUsuarios() {
		return usuarioDAO.findAll();
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	public Usuario usuarioById(Long id) {
		return usuarioDAO.findById(id).get();
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	public void deleteUsuario(Long id) {
		usuarioDAO.deleteById(id);
	}

}