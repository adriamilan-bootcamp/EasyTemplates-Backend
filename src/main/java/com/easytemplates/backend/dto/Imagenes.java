// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.easytemplates.backend.security.SecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity(name="imagenes")
public class Imagenes implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    @JsonView(SecurityRole.role_user.class)
    private Long id;
    
    @Column(length=255)
    @JsonView(SecurityRole.role_user.class)
    private String src;
    
    @Column(name="fecha_creacion")
    @JsonView(SecurityRole.role_user.class)
    private LocalDateTime fechaCreacion;
    
    @JsonIgnore
    @OneToMany(mappedBy="imagenes")
    private Set<GruposImagenes> gruposImagenes;
    
    @JsonIgnore
    @OneToMany(mappedBy="imagenes")
    private Set<PlantillasUsanImagenes> plantillasUsanImagenes;
    
    @JsonIgnore
    @OneToMany(mappedBy="imagenes")
    private Set<UsuariosImagenes> usuariosImagenes;

    /** Default constructor. */
    public Imagenes() {
        super();
        this.fechaCreacion = LocalDateTime.now();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(Long aId) {
        id = aId;
    }

    /**
     * Access method for src.
     *
     * @return the current value of src
     */
    public String getSrc() {
        return src;
    }

    /**
     * Setter method for src.
     *
     * @param aSrc the new value for src
     */
    public void setSrc(String aSrc) {
        src = aSrc;
    }

    /**
     * Access method for fechaCreacion.
     *
     * @return the current value of fechaCreacion
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Setter method for fechaCreacion.
     *
     * @param aFechaCreacion the new value for fechaCreacion
     */
    public void setFechaCreacion(LocalDateTime aFechaCreacion) {
        fechaCreacion = aFechaCreacion;
    }

    /**
     * Access method for gruposImagenes.
     *
     * @return the current value of gruposImagenes
     */
    public Set<GruposImagenes> getGruposImagenes() {
        return gruposImagenes;
    }

    /**
     * Setter method for gruposImagenes.
     *
     * @param aGruposImagenes the new value for gruposImagenes
     */
    public void setGruposImagenes(Set<GruposImagenes> aGruposImagenes) {
        gruposImagenes = aGruposImagenes;
    }

    /**
     * Access method for plantillasUsanImagenes.
     *
     * @return the current value of plantillasUsanImagenes
     */
    public Set<PlantillasUsanImagenes> getPlantillasUsanImagenes() {
        return plantillasUsanImagenes;
    }

    /**
     * Setter method for plantillasUsanImagenes.
     *
     * @param aPlantillasUsanImagenes the new value for plantillasUsanImagenes
     */
    public void setPlantillasUsanImagenes(Set<PlantillasUsanImagenes> aPlantillasUsanImagenes) {
        plantillasUsanImagenes = aPlantillasUsanImagenes;
    }

    /**
     * Access method for usuariosImagenes.
     *
     * @return the current value of usuariosImagenes
     */
    public Set<UsuariosImagenes> getUsuariosImagenes() {
        return usuariosImagenes;
    }

    /**
     * Setter method for usuariosImagenes.
     *
     * @param aUsuariosImagenes the new value for usuariosImagenes
     */
    public void setUsuariosImagenes(Set<UsuariosImagenes> aUsuariosImagenes) {
        usuariosImagenes = aUsuariosImagenes;
    }

    @Override
	public String toString() {
		return "Imagenes [id=" + id + ", src=" + src + ", fechaCreacion=" + fechaCreacion.toString() + "]";
	}
}
