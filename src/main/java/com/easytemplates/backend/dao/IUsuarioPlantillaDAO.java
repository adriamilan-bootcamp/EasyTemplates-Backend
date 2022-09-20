package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.UsuariosPlantillas;

public interface IUsuarioPlantillaDAO extends JpaRepository<UsuariosPlantillas, Long>{
	List<UsuariosPlantillas> findPlantillasByUsuariosId(Long id);
}
