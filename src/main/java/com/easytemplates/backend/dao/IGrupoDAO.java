package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Grupos;
import com.easytemplates.backend.dto.Usuarios;

public interface IGrupoDAO extends JpaRepository<Grupos, Long> {
	List<Grupos> findGruposByNombre(String nombre);
	List<Grupos> findGruposByUsuariosId(Long id);
}