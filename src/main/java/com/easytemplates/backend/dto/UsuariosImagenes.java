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

@Entity(name="usuarios_imagenes")
public class UsuariosImagenes implements Serializable {

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
    private int id;
    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuarios usuarios;
    @ManyToOne
    @JoinColumn(name="imagen")
    private Imagenes imagenes;

    /** Default constructor. */
    public UsuariosImagenes() {
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
     * Access method for usuarios.
     *
     * @return the current value of usuarios
     */
    public Usuarios getUsuarios() {
        return usuarios;
    }

    /**
     * Setter method for usuarios.
     *
     * @param aUsuarios the new value for usuarios
     */
    public void setUsuarios(Usuarios aUsuarios) {
        usuarios = aUsuarios;
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
     * Compares the key for this instance with another UsuariosImagenes.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UsuariosImagenes and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UsuariosImagenes)) {
            return false;
        }
        UsuariosImagenes that = (UsuariosImagenes) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UsuariosImagenes.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UsuariosImagenes)) return false;
        return this.equalKeys(other) && ((UsuariosImagenes)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[UsuariosImagenes |");
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
