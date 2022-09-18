// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="plantillas")
public class Plantillas implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private Long id;
    @Column(length=255)
    private String titulo;
    @Column(length=255)
    private String src;
    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;
    @OneToMany(mappedBy="plantillas")
    private Set<GruposPlantillas> gruposPlantillas;
    @OneToMany(mappedBy="plantillas")
    private Set<PlantillasUsanImagenes> plantillasUsanImagenes;
    @OneToMany(mappedBy="plantillas")
    private Set<UsuariosPlantillas> usuariosPlantillas;

    /** Default constructor. */
    public Plantillas() {
        super();
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
     * Access method for titulo.
     *
     * @return the current value of titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter method for titulo.
     *
     * @param aTitulo the new value for titulo
     */
    public void setTitulo(String aTitulo) {
        titulo = aTitulo;
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
     * Access method for gruposPlantillas.
     *
     * @return the current value of gruposPlantillas
     */
    @JsonIgnore
    public Set<GruposPlantillas> getGruposPlantillas() {
        return gruposPlantillas;
    }

    /**
     * Setter method for gruposPlantillas.
     *
     * @param aGruposPlantillas the new value for gruposPlantillas
     */
    public void setGruposPlantillas(Set<GruposPlantillas> aGruposPlantillas) {
        gruposPlantillas = aGruposPlantillas;
    }

    /**
     * Access method for plantillasUsanImagenes.
     *
     * @return the current value of plantillasUsanImagenes
     */
    @JsonIgnore
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
     * Access method for usuariosPlantillas.
     *
     * @return the current value of usuariosPlantillas
     */
    @JsonIgnore
    public Set<UsuariosPlantillas> getUsuariosPlantillas() {
        return usuariosPlantillas;
    }

    /**
     * Setter method for usuariosPlantillas.
     *
     * @param aUsuariosPlantillas the new value for usuariosPlantillas
     */
    public void setUsuariosPlantillas(Set<UsuariosPlantillas> aUsuariosPlantillas) {
        usuariosPlantillas = aUsuariosPlantillas;
    }

    /**
     * Compares the key for this instance with another Plantillas.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Plantillas and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Plantillas)) {
            return false;
        }
        Plantillas that = (Plantillas) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Plantillas.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Plantillas)) return false;
        return this.equalKeys(other) && ((Plantillas)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
    	Long i;
        int result;
        i = getId();
        result = (37 * 1337);
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Plantillas |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id",getId());
        return ret;
    }

}
