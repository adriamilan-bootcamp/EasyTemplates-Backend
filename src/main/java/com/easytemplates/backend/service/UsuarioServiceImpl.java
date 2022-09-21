package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Usuarios;

@Service("userDetailsService")
public class UsuarioServiceImpl implements IUsuarioService,UserDetailsService {
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
		try {
			Usuarios user = usuarioDAO.findById(id).get();
			
			return user;
			
		} catch (RuntimeException re) {
            return null;
        }		
	}

	@Override
	public Usuarios updateUsuario(Usuarios usuario) {
		return usuarioDAO.save(usuario);
	}

	@Override
	public void deleteUsuario(Long id) {
		usuarioDAO.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		Usuarios user = usuarioDAO.findByEmail(username);
		
		if (user == null) {
			return null;
		}
		
		return (Usuarios) user;
	}

	

}