package com.easytemplates.backend.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Pdfs;

public interface IPdfDAO extends JpaRepository<Pdfs, Long> {
	List<Pdfs> findByTitulo(String titulo);
	
}