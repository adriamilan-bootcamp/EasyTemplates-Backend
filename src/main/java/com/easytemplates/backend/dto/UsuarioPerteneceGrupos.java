// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="usuarios_pertenecen_grupos")
@IdClass(UsuarioPerteneceGrupos.UsuariosPertenecenGruposId.class)
public class UsuarioPerteneceGrupos implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class UsuariosPertenecenGruposId implements Serializable {
        Usuario usuarios;
        Grupo grupos;
    }

    /** Primary key. */
    protected static final String PK = "UsuariosPertenecenGruposPrimary";

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
    @Id
    @JoinColumn(name="grupo_id", nullable=false)
    private Grupo grupos;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuarios;

    /** Default constructor. */
    public UsuarioPerteneceGrupos() {
        super();
    }

    /**
     * Access method for grupos.
     *
     * @return the current value of grupos
     */
    public Grupo getGrupos() {
        return grupos;
    }

    /**
     * Setter method for grupos.
     *
     * @param aGrupos the new value for grupos
     */
    public void setGrupos(Grupo aGrupos) {
        grupos = aGrupos;
    }

    /**
     * Access method for usuarios.
     *
     * @return the current value of usuarios
     */
    public Usuario getUsuarios() {
        return usuarios;
    }

    /**
     * Setter method for usuarios.
     *
     * @param aUsuarios the new value for usuarios
     */
    public void setUsuarios(Usuario aUsuarios) {
        usuarios = aUsuarios;
    }

    /** Temporary value holder for group key fragment usuariosId */
    private transient int tempUsuariosId;

    /**
     * Gets the key fragment id for member usuarios.
     * If this.usuarios is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setUsuariosId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Usuario
     */
    public int getUsuariosId() {
        return (getUsuarios() == null ? tempUsuariosId : getUsuarios().getId());
    }

    /**
     * Sets the key fragment id from member usuarios.
     * If this.usuarios is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getUsuariosId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Usuario
     */
    public void setUsuariosId(int aId) {
        if (getUsuarios() == null) {
            tempUsuariosId = aId;
        } else {
            getUsuarios().setId(aId);
        }
    }

    /** Temporary value holder for group key fragment gruposId */
    private transient int tempGruposId;

    /**
     * Gets the key fragment id for member grupos.
     * If this.grupos is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setGruposId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Grupo
     */
    public int getGruposId() {
        return (getGrupos() == null ? tempGruposId : getGrupos().getId());
    }

    /**
     * Sets the key fragment id from member grupos.
     * If this.grupos is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getGruposId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Grupo
     */
    public void setGruposId(int aId) {
        if (getGrupos() == null) {
            tempGruposId = aId;
        } else {
            getGrupos().setId(aId);
        }
    }

    /**
     * Compares the key for this instance with another UsuariosPertenecenGrupos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UsuariosPertenecenGrupos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UsuarioPerteneceGrupos)) {
            return false;
        }
        UsuarioPerteneceGrupos that = (UsuarioPerteneceGrupos) other;
        if (this.getUsuariosId() != that.getUsuariosId()) {
            return false;
        }
        if (this.getGruposId() != that.getGruposId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UsuariosPertenecenGrupos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UsuarioPerteneceGrupos)) return false;
        return this.equalKeys(other) && ((UsuarioPerteneceGrupos)other).equalKeys(this);
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
        i = getUsuariosId();
        result = 37*result + i;
        i = getGruposId();
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
        StringBuffer sb = new StringBuffer("[UsuariosPertenecenGrupos |");
        sb.append(" usuariosId=").append(getUsuariosId());
        sb.append(" gruposId=").append(getGruposId());
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
        ret.put("usuariosId", Integer.valueOf(getUsuariosId()));
        ret.put("gruposId", Integer.valueOf(getGruposId()));
        return ret;
    }

}
