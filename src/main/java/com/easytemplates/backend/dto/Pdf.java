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

@Entity(name="pdfs")

public class Pdf implements Serializable {

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
    @Column(length=100)
    private String titulo;
    @Column(length=255)
    private String src;
    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;
    @OneToMany(mappedBy="pdfs")
    private Set<GrupoTienenDocs> gruposTienenDocs;
    @OneToMany(mappedBy="pdfs")
    private Set<UsuarioTieneDocs> usuariosTienenDocs;

    /** Default constructor. */
    public Pdf() {
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
     * Access method for gruposTienenDocs.
     *
     * @return the current value of gruposTienenDocs
     */
    public Set<GrupoTienenDocs> getGrupoTienenDocs() {
        return gruposTienenDocs;
    }

    /**
     * Setter method for gruposTienenDocs.
     *
     * @param aGrupoTienenDocs the new value for gruposTienenDocs
     */
    public void setGrupoTienenDocs(Set<GrupoTienenDocs> aGrupoTienenDocs) {
        gruposTienenDocs = aGrupoTienenDocs;
    }

    /**
     * Access method for usuariosTienenDocs.
     *
     * @return the current value of usuariosTienenDocs
     */
    public Set<UsuarioTieneDocs> getUsuarioTieneDocs() {
        return usuariosTienenDocs;
    }

    /**
     * Setter method for usuariosTienenDocs.
     *
     * @param aUsuarioTieneDocs the new value for usuariosTienenDocs
     */
    public void setUsuarioTieneDocs(Set<UsuarioTieneDocs> aUsuarioTieneDocs) {
        usuariosTienenDocs = aUsuarioTieneDocs;
    }

    /**
     * Compares the key for this instance with another Pdf.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Pdf and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Pdf)) {
            return false;
        }
        Pdf that = (Pdf) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Pdf.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pdf)) return false;
        return this.equalKeys(other) && ((Pdf)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Pdf |");
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
