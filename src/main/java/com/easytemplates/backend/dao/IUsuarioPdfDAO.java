package com.easytemplates.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.UsuariosPdfs;

public interface IUsuarioPdfDAO extends JpaRepository<UsuariosPdfs, Long>{

}
