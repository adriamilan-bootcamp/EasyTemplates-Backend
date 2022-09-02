package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Imagenes;

public interface IImagenDAO extends JpaRepository<Imagenes, Long>{

}
