package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Usuarios;
public interface IUsuarioDAO extends JpaRepository<Usuarios, Long> {
	Usuarios findByNombre(String username);
	Usuarios findByEmail(String email);
	
}