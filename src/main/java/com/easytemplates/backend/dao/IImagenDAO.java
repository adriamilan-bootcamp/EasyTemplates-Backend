package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Imagen;

public interface IImagenDAO extends JpaRepository<Imagen, Long>{

}
