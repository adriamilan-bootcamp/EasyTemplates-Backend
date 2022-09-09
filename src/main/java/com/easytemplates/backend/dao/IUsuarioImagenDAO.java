package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.UsuariosImagenes;

public interface IUsuarioImagenDAO extends JpaRepository<UsuariosImagenes, Long>{

	public List<UsuariosImagenes> findByUsuarios(Long id);
	
}
