package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Usuarios;
public interface IUsuarioDAO extends JpaRepository<Usuarios, Long> {
	Usuarios findByUsername(String username);
	Usuarios findByEmail(String email);
}