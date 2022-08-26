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

@Entity(name="grupos_tienen_docs")
@IdClass(GrupoTieneDocs.GrupoTieneDocsId.class)
public class GrupoTieneDocs implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class GrupoTieneDocsId implements Serializable {
        Grupo grupos;
        Plantilla plantillas;
        Imagen imagenes;
        Pdf pdfs;
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

    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="grupo_id", nullable=false)
    private Grupo grupos;
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

    /** Default constructor. */
    public GrupoTieneDocs() {
        super();
    }

    /**
     * Access method for grupos.
     *
     * @return the current value of grupos
     */
    public Grupo getGrupo() {
        return grupos;
    }

    /**
     * Setter method for grupos.
     *
     * @param aGrupo the new value for grupos
     */
    public void setGrupo(Grupo aGrupo) {
        grupos = aGrupo;
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

    /** Temporary value holder for group key fragment gruposId */
    private transient int tempGrupoId;

    /**
     * Gets the key fragment id for member grupos.
     * If this.grupos is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setGrupoId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Grupo
     */
    public int getGrupoId() {
        return (getGrupo() == null ? tempGrupoId : getGrupo().getId());
    }

    /**
     * Sets the key fragment id from member grupos.
     * If this.grupos is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getGrupoId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Grupo
     */
    public void setGrupoId(int aId) {
        if (getGrupo() == null) {
            tempGrupoId = aId;
        } else {
            getGrupo().setId(aId);
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
        if (this.getGrupoId() != that.getGrupoId()) {
            return false;
        }
        if (this.getPlantillaId() != that.getPlantillaId()) {
            return false;
        }
        if (this.getImagenId() != that.getImagenId()) {
            return false;
        }
        if (this.getPdfId() != that.getPdfId()) {
            return false;
        }
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
        i = getGrupoId();
        result = 37*result + i;
        i = getPlantillaId();
        result = 37*result + i;
        i = getImagenId();
        result = 37*result + i;
        i = getPdfId();
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
        StringBuffer sb = new StringBuffer("[GrupoTieneDocs |");
        sb.append(" gruposId=").append(getGrupoId());
        sb.append(" plantillasId=").append(getPlantillaId());
        sb.append(" imagenesId=").append(getImagenId());
        sb.append(" pdfsId=").append(getPdfId());
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
        ret.put("gruposId", Integer.valueOf(getGrupoId()));
        ret.put("plantillasId", Integer.valueOf(getPlantillaId()));
        ret.put("imagenesId", Integer.valueOf(getImagenId()));
        ret.put("pdfsId", Integer.valueOf(getPdfId()));
        return ret;
    }

}
