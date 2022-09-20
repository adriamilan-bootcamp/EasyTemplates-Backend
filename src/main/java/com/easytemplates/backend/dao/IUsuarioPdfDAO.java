package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.UsuariosPdfs;

public interface IUsuarioPdfDAO extends JpaRepository<UsuariosPdfs, Long>{
	List<UsuariosPdfs> findPdfByUsuariosId(Long id);
}
