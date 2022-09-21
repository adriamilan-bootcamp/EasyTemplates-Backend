package com.easytemplates.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Imagenes;
import com.easytemplates.backend.dto.UsuariosImagenes;

public interface IUsuarioImagenDAO extends JpaRepository<UsuariosImagenes, Long> {

	List<Imagenes> findImagenesByUsuariosId(Long id);

}
