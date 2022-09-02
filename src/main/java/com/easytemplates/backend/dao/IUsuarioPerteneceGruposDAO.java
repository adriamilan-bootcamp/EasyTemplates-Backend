package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Grupos;
import com.easytemplates.backend.dto.Usuarios;
import com.easytemplates.backend.dto.UsuariosPertenecenGrupos;



public interface IUsuarioPerteneceGruposDAO extends JpaRepository<UsuariosPertenecenGrupos, Long> {
	Grupos findByGrupos(String grupo_name);
}