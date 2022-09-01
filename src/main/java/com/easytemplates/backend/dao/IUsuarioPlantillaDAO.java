package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.UsuariosPlantillas;

public interface IUsuarioPlantillaDAO extends JpaRepository<UsuariosPlantillas, Long>{

}
