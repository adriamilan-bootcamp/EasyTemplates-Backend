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

import com.easytemplates.backend.security.SecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity(name="pdfs")
public class Pdfs implements Serializable {

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
    
    @Column(length=100)
    @JsonView(SecurityRole.role_user.class)
    private String titulo;
    
    @Column(length=255)
    @JsonView(SecurityRole.role_user.class)
    private String src;
    
    @Column(name="fecha_creacion")
    @JsonView(SecurityRole.role_user.class)
    private LocalDateTime fechaCreacion;
    
    @OneToMany(mappedBy="pdfs")
    @JsonIgnore
    private Set<GruposPdfs> gruposPdfs;
    
    @OneToMany(mappedBy="pdfs")
    @JsonIgnore
    private Set<UsuariosPdfs> usuariosPdfs;

    /** Default constructor. */
    public Pdfs() {
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
     * Access method for gruposPdfs.
     *
     * @return the current value of gruposPdfs
     */
    public Set<GruposPdfs> getGruposPdfs() {
        return gruposPdfs;
    }

    /**
     * Setter method for gruposPdfs.
     *
     * @param aGruposPdfs the new value for gruposPdfs
     */
    public void setGruposPdfs(Set<GruposPdfs> aGruposPdfs) {
        gruposPdfs = aGruposPdfs;
    }

    /**
     * Access method for usuariosPdfs.
     *
     * @return the current value of usuariosPdfs
     */
    public Set<UsuariosPdfs> getUsuariosPdfs() {
        return usuariosPdfs;
    }

    /**
     * Setter method for usuariosPdfs.
     *
     * @param aUsuariosPdfs the new value for usuariosPdfs
     */
    public void setUsuariosPdfs(Set<UsuariosPdfs> aUsuariosPdfs) {
        usuariosPdfs = aUsuariosPdfs;
    }

    /**
     * Compares the key for this instance with another Pdfs.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Pdfs and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Pdfs)) {
            return false;
        }
        Pdfs that = (Pdfs) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Pdfs.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pdfs)) return false;
        return this.equalKeys(other) && ((Pdfs)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Pdfs |");
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
