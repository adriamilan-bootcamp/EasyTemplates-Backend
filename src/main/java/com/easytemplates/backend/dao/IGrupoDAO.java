package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Grupo;

public interface IGrupoDAO extends JpaRepository<Grupo, Long> {
	
}