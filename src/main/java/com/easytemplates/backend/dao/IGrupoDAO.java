package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Grupos;

public interface IGrupoDAO extends JpaRepository<Grupos, Long> {
	
}