package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.GrupoTieneDocs;

public interface IGrupoTieneDocsDAO extends JpaRepository<GrupoTieneDocs, Long> {
	
}