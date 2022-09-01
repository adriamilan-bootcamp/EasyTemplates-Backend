package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Usuario;
public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
	Usuario findByNombre(String username);
}