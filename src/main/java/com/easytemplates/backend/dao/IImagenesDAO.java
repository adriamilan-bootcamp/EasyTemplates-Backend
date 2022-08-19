package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Imagenes;

public interface IImagenesDAO extends JpaRepository<Imagenes, Long>{

}
