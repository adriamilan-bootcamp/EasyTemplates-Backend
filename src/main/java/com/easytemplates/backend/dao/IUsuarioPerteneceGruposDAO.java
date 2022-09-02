package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.UsuariosPertenecenGrupos;



public interface IUsuarioPerteneceGruposDAO extends JpaRepository<UsuariosPertenecenGrupos, Long> {
	
}