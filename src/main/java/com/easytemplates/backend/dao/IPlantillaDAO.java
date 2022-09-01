package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Plantillas;

public interface IPlantillaDAO extends JpaRepository<Plantillas, Long> {

}
