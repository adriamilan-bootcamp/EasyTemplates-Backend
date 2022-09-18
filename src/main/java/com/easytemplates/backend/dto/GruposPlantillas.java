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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="grupos_plantillas")
public class GruposPlantillas implements Serializable {

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
    @ManyToOne
    @JoinColumn(name="grupo")
    private Grupos grupos;
    @ManyToOne
    @JoinColumn(name="plantilla")
    private Plantillas plantillas;

    /** Default constructor. */
    public GruposPlantillas() {
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
     * Access method for grupos.
     *
     * @return the current value of grupos
     */
    @JsonIgnore
    public Grupos getGrupos() {
        return grupos;
    }

    /**
     * Setter method for grupos.
     *
     * @param aGrupos the new value for grupos
     */
    public void setGrupos(Grupos aGrupos) {
        grupos = aGrupos;
    }

    /**
     * Access method for plantillas.
     *
     * @return the current value of plantillas
     */
    @JsonIgnore
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
     * Compares the key for this instance with another GruposPlantillas.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class GruposPlantillas and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof GruposPlantillas)) {
            return false;
        }
        GruposPlantillas that = (GruposPlantillas) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another GruposPlantillas.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof GruposPlantillas)) return false;
        return this.equalKeys(other) && ((GruposPlantillas)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[GruposPlantillas |");
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
