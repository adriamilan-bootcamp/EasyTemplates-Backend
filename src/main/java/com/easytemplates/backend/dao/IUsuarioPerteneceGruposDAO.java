package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.UsuarioPerteneceGrupos;



public interface IUsuarioPerteneceGruposDAO extends JpaRepository<UsuarioPerteneceGrupos, Long> {
	
}