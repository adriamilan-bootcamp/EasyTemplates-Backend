package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Plantilla;

public interface IPlantillaDAO extends JpaRepository<Plantilla, Long> {

}
