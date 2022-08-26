// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="plantillas_usan_imagenes")
@IdClass(PlantillaUsaImagenes.PlantillaUsaImagenesId.class)
public class PlantillaUsaImagenes implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class PlantillaUsaImagenesId implements Serializable {
    }

    /** Primary key. */
    protected static final String PK = "PlantillaUsaImagenesPrimary";

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

    @ManyToOne(optional=false)
    @JoinColumn(name="imagen_id", nullable=false)
    private Imagen imagen;
    @ManyToOne(optional=false)
    @JoinColumn(name="plantilla_id", nullable=false)
    private Plantilla plantilla;

    /** Default constructor. */
    public PlantillaUsaImagenes() {
        super();
    }

    /**
     * Access method for imagen.
     *
     * @return the current value of imagen
     */
    public Imagen getImagen() {
        return imagen;
    }

    /**
     * Setter method for imagen.
     *
     * @param aImagen the new value for imagen
     */
    public void setImagen(Imagen aImagen) {
        imagen = aImagen;
    }

    /**
     * Access method for plantilla.
     *
     * @return the current value of plantilla
     */
    public Plantilla getPlantilla() {
        return plantilla;
    }

    /**
     * Setter method for plantilla.
     *
     * @param aPlantilla the new value for plantilla
     */
    public void setPlantilla(Plantilla aPlantilla) {
        plantilla = aPlantilla;
    }

    /**
     * Compares the key for this instance with another PlantillaUsaImagenes.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PlantillaUsaImagenes and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PlantillaUsaImagenes)) {
            return false;
        }
        PlantillaUsaImagenes that = (PlantillaUsaImagenes) other;
        return true;
    }

    /**
     * Compares this instance with another PlantillaUsaImagenes.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PlantillaUsaImagenes)) return false;
        return this.equalKeys(other) && ((PlantillaUsaImagenes)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[PlantillaUsaImagenes |");
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
        return ret;
    }

}
