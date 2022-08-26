package com.easytemplates.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.UsuarioTieneDocs;

public interface IUsuarioTieneDocsDAO extends JpaRepository<UsuarioTieneDocs, Long> {
	
}