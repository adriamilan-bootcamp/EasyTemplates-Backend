package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Plantillas;

public interface IPlantillaDAO extends JpaRepository<Plantillas, Long> {
	List<Plantillas> findByTitulo(String titulo);
}
