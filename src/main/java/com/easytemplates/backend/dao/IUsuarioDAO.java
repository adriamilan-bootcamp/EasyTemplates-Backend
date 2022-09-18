package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Imagenes;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.dto.UsuariosPertenecenGrupos;
public interface IUsuarioDAO extends JpaRepository<Usuarios, Long> {
	List<Usuarios> findUsuariosByNombre(String username);
	Usuarios findByEmail(String email);

	List<Usuarios> findUsuariosByGruposId(Long id);
	

	
}