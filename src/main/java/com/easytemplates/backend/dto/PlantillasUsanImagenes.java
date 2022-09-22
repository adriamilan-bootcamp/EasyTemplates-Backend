// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.easytemplates.backend.security.SecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity(name="plantillas_usan_imagenes")
public class PlantillasUsanImagenes implements Serializable {

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
    @JsonView(SecurityRole.role_user.class)
    private int id;
    
    @ManyToOne
    @JoinColumn(name="plantilla")
    @JsonIgnore
    private Plantillas plantillas;
    
    @ManyToOne
    @JoinColumn(name="imagen")
    @JsonIgnore
    private Imagenes imagenes;

    /** Default constructor. */
    public PlantillasUsanImagenes() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for plantillas.
     *
     * @return the current value of plantillas
     */
    public Plantillas getPlantillas() {
        return plantillas;
    }

    /**
     * Setter method for plantillas.
     *
     * @param aPlantillas the new value for plantillas
     */
    public void setPlantillas(Plantillas aPlantillas) {
        plantillas = aPlantillas;
    }

    /**
     * Access method for imagenes.
     *
     * @return the current value of imagenes
     */
    public Imagenes getImagenes() {
        return imagenes;
    }

    /**
     * Setter method for imagenes.
     *
     * @param aImagenes the new value for imagenes
     */
    public void setImagenes(Imagenes aImagenes) {
        imagenes = aImagenes;
    }

    /**
     * Compares the key for this instance with another PlantillasUsanImagenes.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PlantillasUsanImagenes and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PlantillasUsanImagenes)) {
            return false;
        }
        PlantillasUsanImagenes that = (PlantillasUsanImagenes) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PlantillasUsanImagenes.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PlantillasUsanImagenes)) return false;
        return this.equalKeys(other) && ((PlantillasUsanImagenes)other).equalKeys(this);
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
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[PlantillasUsanImagenes |");
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
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
