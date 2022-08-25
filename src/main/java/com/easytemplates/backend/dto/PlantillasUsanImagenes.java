package com.easytemplates.backend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="plantillas_usan_imagenes")
public class PlantillasUsanImagenes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinColumn(name = "id")
	private Imagen imagen;
	
	@ManyToMany
	@JoinColumn(name = "id")
	private Plantilla plantilla;
	
}
