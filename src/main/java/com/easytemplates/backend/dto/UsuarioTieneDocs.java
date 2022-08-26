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

@Entity(name="usuarios_tienen_docs")
@IdClass(UsuarioTieneDocs.UsuarioTieneDocsId.class)
public class UsuarioTieneDocs implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class UsuarioTieneDocsId implements Serializable {
        Usuario usuarios;
        Pdf pdfs;
        Imagen imagenes;
        Plantilla plantillas;
    }

    /** Primary key. */
    protected static final String PK = "UsuarioTieneDocsPrimary";

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
    @JoinColumn(name="imagen_id", nullable=false)
    private Imagen imagenes;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="pdf_id", nullable=false)
    private Pdf pdfs;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="plantilla_id", nullable=false)
    private Plantilla plantillas;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuarios;

    /** Default constructor. */
    public UsuarioTieneDocs() {
        super();
    }

    /**
     * Access method for imagenes.
     *
     * @return the current value of imagenes
     */
    public Imagen getImagen() {
        return imagenes;
    }

    /**
     * Setter method for imagenes.
     *
     * @param aImagen the new value for imagenes
     */
    public void setImagen(Imagen aImagen) {
        imagenes = aImagen;
    }

    /**
     * Access method for pdfs.
     *
     * @return the current value of pdfs
     */
    public Pdf getPdf() {
        return pdfs;
    }

    /**
     * Setter method for pdfs.
     *
     * @param aPdf the new value for pdfs
     */
    public void setPdf(Pdf aPdf) {
        pdfs = aPdf;
    }

    /**
     * Access method for plantillas.
     *
     * @return the current value of plantillas
     */
    public Plantilla getPlantilla() {
        return plantillas;
    }

    /**
     * Setter method for plantillas.
     *
     * @param aPlantilla the new value for plantillas
     */
    public void setPlantilla(Plantilla aPlantilla) {
        plantillas = aPlantilla;
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
     * @see Usuarios
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
     * @see Usuarios
     */
    public void setUsuariosId(int aId) {
        if (getUsuarios() == null) {
            tempUsuariosId = aId;
        } else {
            getUsuarios().setId(aId);
        }
    }

    /** Temporary value holder for group key fragment pdfsId */
    private transient int tempPdfId;

    /**
     * Gets the key fragment id for member pdfs.
     * If this.pdfs is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPdfId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Pdf
     */
    public int getPdfId() {
        return (getPdf() == null ? tempPdfId : getPdf().getId());
    }

    /**
     * Sets the key fragment id from member pdfs.
     * If this.pdfs is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPdfId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Pdf
     */
    public void setPdfId(int aId) {
        if (getPdf() == null) {
            tempPdfId = aId;
        } else {
            getPdf().setId(aId);
        }
    }

    /** Temporary value holder for group key fragment imagenesId */
    private transient int tempImagenId;

    /**
     * Gets the key fragment id for member imagenes.
     * If this.imagenes is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setImagenId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Imagen
     */
    public int getImagenId() {
        return (getImagen() == null ? tempImagenId : getImagen().getId());
    }

    /**
     * Sets the key fragment id from member imagenes.
     * If this.imagenes is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getImagenId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Imagen
     */
    public void setImagenId(int aId) {
        if (getImagen() == null) {
            tempImagenId = aId;
        } else {
            getImagen().setId(aId);
        }
    }

    /** Temporary value holder for group key fragment plantillasId */
    private transient int tempPlantillaId;

    /**
     * Gets the key fragment id for member plantillas.
     * If this.plantillas is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPlantillaId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Plantilla
     */
    public int getPlantillaId() {
        return (getPlantilla() == null ? tempPlantillaId : getPlantilla().getId());
    }

    /**
     * Sets the key fragment id from member plantillas.
     * If this.plantillas is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPlantillaId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Plantilla
     */
    public void setPlantillaId(int aId) {
        if (getPlantilla() == null) {
            tempPlantillaId = aId;
        } else {
            getPlantilla().setId(aId);
        }
    }

    /**
     * Compares the key for this instance with another UsuarioTieneDocs.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UsuarioTieneDocs and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UsuarioTieneDocs)) {
            return false;
        }
        UsuarioTieneDocs that = (UsuarioTieneDocs) other;
        if (this.getUsuariosId() != that.getUsuariosId()) {
            return false;
        }
        if (this.getPdfId() != that.getPdfId()) {
            return false;
        }
        if (this.getImagenId() != that.getImagenId()) {
            return false;
        }
        if (this.getPlantillaId() != that.getPlantillaId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UsuarioTieneDocs.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UsuarioTieneDocs)) return false;
        return this.equalKeys(other) && ((UsuarioTieneDocs)other).equalKeys(this);
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
        i = getPdfId();
        result = 37*result + i;
        i = getImagenId();
        result = 37*result + i;
        i = getPlantillaId();
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
        StringBuffer sb = new StringBuffer("[UsuarioTieneDocs |");
        sb.append(" usuariosId=").append(getUsuariosId());
        sb.append(" pdfsId=").append(getPdfId());
        sb.append(" imagenesId=").append(getImagenId());
        sb.append(" plantillasId=").append(getPlantillaId());
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
        ret.put("pdfsId", Integer.valueOf(getPdfId()));
        ret.put("imagenesId", Integer.valueOf(getImagenId()));
        ret.put("plantillasId", Integer.valueOf(getPlantillaId()));
        return ret;
    }

}
