package com.easytemplates.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.easytemplates.backend.dto.Pdf;

public interface IPdfDAO extends JpaRepository<Pdf, Long> {
	
}