// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="grupos_tienen_docs")
@IdClass(GrupoTieneDocs.GrupoTieneDocsId.class)
public class GrupoTieneDocs implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class GrupoTieneDocsId implements Serializable {
    }

    /** Primary key. */
    protected static final String PK = "GrupoTieneDocsPrimary";

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


    /** Default constructor. */
    public GrupoTieneDocs() {
        super();
    }

    /**
     * Compares the key for this instance with another GrupoTieneDocs.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class GrupoTieneDocs and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof GrupoTieneDocs)) {
            return false;
        }
        GrupoTieneDocs that = (GrupoTieneDocs) other;
        return true;
    }

    /**
     * Compares this instance with another GrupoTieneDocs.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof GrupoTieneDocs)) return false;
        return this.equalKeys(other) && ((GrupoTieneDocs)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[GrupoTieneDocs |");
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
