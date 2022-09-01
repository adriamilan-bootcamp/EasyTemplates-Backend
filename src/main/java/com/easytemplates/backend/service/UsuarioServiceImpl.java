package com.easytemplates.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IUsuarioDAO;
import com.easytemplates.backend.dto.Usuario;
import static java.util.Collections.emptyList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {
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

	@Override
	public Usuario usuarioByUsername(String username) {
		return usuarioDAO.findByNombre(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioDAO.findByNombre(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getNombre(), user.getPassword(), emptyList());
	} 

}