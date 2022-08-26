package com.easytemplates.backend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PlantillasUsanImagenes")

public class PlantillasUsanImagenes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne
	@JoinColumn(name="imagen")
	private Imagen imagen;
	
	@ManyToOne
	@JoinColumn(name="plantilla")
	private Plantilla plantilla;
	
	// Constructor por defecto
	public PlantillasUsanImagenes() {
		
	}

	/**
	 * @param id
	 * @param imagen
	 * @param plantilla
	 */
	public PlantillasUsanImagenes(Long id, Imagen imagen, Plantilla plantilla) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.plantilla = plantilla;
	}

	/**
	 * @return the imagen
	 */
	public Imagen getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the plantilla
	 */
	public Plantilla getPlantilla() {
		return plantilla;
	}

	/**
	 * @param plantilla the plantilla to set
	 */
	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "PlantillasUsanImagenes [id=" + id + "]";
	}
	

}
