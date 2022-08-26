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

@Entity(name="usuarios_tienen_docs")
public class UsuarioTieneDocs implements Serializable {

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
    @JoinColumn(name="imagen_id")
    private Imagen imagen;
    @ManyToOne
    @JoinColumn(name="pdf_id")
    private Pdf pdf;
    @ManyToOne
    @JoinColumn(name="plantilla_id")
    private Plantilla plantilla;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    /** Default constructor. */
    public UsuarioTieneDocs() {
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
     * Access method for imagen.
     *
     * @return the current value of imagen
     */
    public Imagen getImagen() {
        return imagen;
    }

    /**
     * Setter method for imagen.
     *
     * @param aImagen the new value for imagen
     */
    public void setImagen(Imagen aImagen) {
        imagen = aImagen;
    }

    /**
     * Access method for pdf.
     *
     * @return the current value of pdf
     */
    public Pdf getPdf() {
        return pdf;
    }

    /**
     * Setter method for pdf.
     *
     * @param aPdf the new value for pdf
     */
    public void setPdf(Pdf aPdf) {
        pdf = aPdf;
    }

    /**
     * Access method for plantilla.
     *
     * @return the current value of plantilla
     */
    public Plantilla getPlantilla() {
        return plantilla;
    }

    /**
     * Setter method for plantilla.
     *
     * @param aPlantilla the new value for plantilla
     */
    public void setPlantilla(Plantilla aPlantilla) {
        plantilla = aPlantilla;
    }

    /**
     * Access method for usuario.
     *
     * @return the current value of usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Setter method for usuario.
     *
     * @param aUsuario the new value for usuario
     */
    public void setUsuario(Usuario aUsuario) {
        usuario = aUsuario;
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
        if (this.getId() != that.getId()) {
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
        StringBuffer sb = new StringBuffer("[UsuarioTieneDocs |");
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
