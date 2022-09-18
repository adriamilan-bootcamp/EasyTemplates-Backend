package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Imagenes;

public interface IImagenDAO extends JpaRepository<Imagenes, Long>{
	

}
