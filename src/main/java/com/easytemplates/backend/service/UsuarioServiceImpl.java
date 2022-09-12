package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Usuarios;
import static java.util.Collections.emptyList;

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuarios user = usuarioDAO.findByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return (Usuarios) user;
	}

	@Override
	public Usuarios usuarioByNombre(String username) {
		return usuarioDAO.findByNombre(username);
	}

}