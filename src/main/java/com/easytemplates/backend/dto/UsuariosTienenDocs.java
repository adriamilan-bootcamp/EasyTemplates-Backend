// Generated with g9.

package jpa;

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
@IdClass(UsuariosTienenDocs.UsuariosTienenDocsId.class)
public class UsuariosTienenDocs implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class UsuariosTienenDocsId implements Serializable {
        Usuarios usuarios;
        Pdfs pdfs;
        Imagenes imagenes;
        Plantillas plantillas;
    }

    /** Primary key. */
    protected static final String PK = "UsuariosTienenDocsPrimary";

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
    private Imagenes imagenes;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="pdf_id", nullable=false)
    private Pdfs pdfs;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="plantilla_id", nullable=false)
    private Plantillas plantillas;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuarios usuarios;

    /** Default constructor. */
    public UsuariosTienenDocs() {
        super();
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
     * Access method for pdfs.
     *
     * @return the current value of pdfs
     */
    public Pdfs getPdfs() {
        return pdfs;
    }

    /**
     * Setter method for pdfs.
     *
     * @param aPdfs the new value for pdfs
     */
    public void setPdfs(Pdfs aPdfs) {
        pdfs = aPdfs;
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
    private transient int tempPdfsId;

    /**
     * Gets the key fragment id for member pdfs.
     * If this.pdfs is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPdfsId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Pdfs
     */
    public int getPdfsId() {
        return (getPdfs() == null ? tempPdfsId : getPdfs().getId());
    }

    /**
     * Sets the key fragment id from member pdfs.
     * If this.pdfs is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPdfsId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Pdfs
     */
    public void setPdfsId(int aId) {
        if (getPdfs() == null) {
            tempPdfsId = aId;
        } else {
            getPdfs().setId(aId);
        }
    }

    /** Temporary value holder for group key fragment imagenesId */
    private transient int tempImagenesId;

    /**
     * Gets the key fragment id for member imagenes.
     * If this.imagenes is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setImagenesId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Imagenes
     */
    public int getImagenesId() {
        return (getImagenes() == null ? tempImagenesId : getImagenes().getId());
    }

    /**
     * Sets the key fragment id from member imagenes.
     * If this.imagenes is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getImagenesId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Imagenes
     */
    public void setImagenesId(int aId) {
        if (getImagenes() == null) {
            tempImagenesId = aId;
        } else {
            getImagenes().setId(aId);
        }
    }

    /** Temporary value holder for group key fragment plantillasId */
    private transient int tempPlantillasId;

    /**
     * Gets the key fragment id for member plantillas.
     * If this.plantillas is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPlantillasId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Plantillas
     */
    public int getPlantillasId() {
        return (getPlantillas() == null ? tempPlantillasId : getPlantillas().getId());
    }

    /**
     * Sets the key fragment id from member plantillas.
     * If this.plantillas is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPlantillasId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Plantillas
     */
    public void setPlantillasId(int aId) {
        if (getPlantillas() == null) {
            tempPlantillasId = aId;
        } else {
            getPlantillas().setId(aId);
        }
    }

    /**
     * Compares the key for this instance with another UsuariosTienenDocs.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UsuariosTienenDocs and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UsuariosTienenDocs)) {
            return false;
        }
        UsuariosTienenDocs that = (UsuariosTienenDocs) other;
        if (this.getUsuariosId() != that.getUsuariosId()) {
            return false;
        }
        if (this.getPdfsId() != that.getPdfsId()) {
            return false;
        }
        if (this.getImagenesId() != that.getImagenesId()) {
            return false;
        }
        if (this.getPlantillasId() != that.getPlantillasId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UsuariosTienenDocs.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UsuariosTienenDocs)) return false;
        return this.equalKeys(other) && ((UsuariosTienenDocs)other).equalKeys(this);
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
        i = getPdfsId();
        result = 37*result + i;
        i = getImagenesId();
        result = 37*result + i;
        i = getPlantillasId();
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
        StringBuffer sb = new StringBuffer("[UsuariosTienenDocs |");
        sb.append(" usuariosId=").append(getUsuariosId());
        sb.append(" pdfsId=").append(getPdfsId());
        sb.append(" imagenesId=").append(getImagenesId());
        sb.append(" plantillasId=").append(getPlantillasId());
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
        ret.put("pdfsId", Integer.valueOf(getPdfsId()));
        ret.put("imagenesId", Integer.valueOf(getImagenesId()));
        ret.put("plantillasId", Integer.valueOf(getPlantillasId()));
        return ret;
    }

}
