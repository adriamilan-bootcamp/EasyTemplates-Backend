package com.easytemplates.backend.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="plantillas")
public class Plantilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="src")
	private String src;
	
	/*
	 * Tabla intermedia
	 * Entre Plantillas - Imagenes
	 * Nombre de la tabla: PlantillasUsanImagenes
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="plantilla")
	private List<PlantillasUsanImagenes> plantillasUsanImagenes;

	/*
	 * Tabla intermedia
	 * Entre Usuarios - Plantillas
	 * Nombre de la tabla: UsuariosTienenDocs
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="plantilla")
	private List<UsuarioTieneDocs> usuariosTienenDocs;
	
	/*
	 * Tabla intermedia
	 * Entre Grupos - Imagenes
	 * Nombre de la tabla: GruposTienenDocs
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="plantilla")
	private List<GrupoTieneDocs> gruposTienenDocs;
	
	// Constructor por defecto
	public Plantilla() {
		
	}

	/**
	 * @param id
	 * @param titulo
	 * @param src
	 */
	public Plantilla(Long id, String titulo, String src) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.src = src;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @return the plantillasUsanImagenes
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "PlantillasUsanImagenes")
	public List<PlantillasUsanImagenes> getPlantillasUsanImagenes() {
		return plantillasUsanImagenes;
	}

	/**
	 * @param ventas the ventas to set
	 */
	public void setPlantillasUsanImagenes(List<PlantillasUsanImagenes> plantillasUsanImagenes) {
		this.plantillasUsanImagenes = plantillasUsanImagenes;
	}
	
	/**
	 * @return the usuariosTienenDocs
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "UsuarioTieneDocs")
	public List<UsuarioTieneDocs> getUsuariosTienenDocs() {
		return usuariosTienenDocs;
	}

	/**
	 * @param usuariosTienenDocs the usuariosTienenDocs to set
	 */
	public void setUsuariosTienenDocs(List<UsuarioTieneDocs> usuariosTienenDocs) {
		this.usuariosTienenDocs = usuariosTienenDocs;
	}
	
	/**
	 * @return the usuariosTienenDocs
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "GruposTienenDocs")
	public List<GrupoTieneDocs> getGruposTienenDocs() {
		return gruposTienenDocs;
	}

	/**
	 * @param usuariosTienenDocs the usuariosTienenDocs to set
	 */
	public void setGruposTienenDocs(List<GrupoTieneDocs> gruposTienenDocs) {
		this.gruposTienenDocs = gruposTienenDocs;
	}

	@Override
	public String toString() {
		return "Plantilla [id=" + id + ", titulo=" + titulo + ", src=" + src + "]";
	}
	
}
