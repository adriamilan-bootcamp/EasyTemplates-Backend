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

@Entity(name="grupos_tienen_docs")
public class GrupoTieneDocs implements Serializable {

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
    @JoinColumn(name="grupo_id")
    private Grupo grupo;
    @ManyToOne
    @JoinColumn(name="imagen_id")
    private Imagen imagen;
    @ManyToOne
    @JoinColumn(name="pdf_id")
    private Pdf pdf;
    @ManyToOne
    @JoinColumn(name="plantilla_id")
    private Plantilla plantilla;

    /** Default constructor. */
    public GrupoTieneDocs() {
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
     * Access method for grupo.
     *
     * @return the current value of grupo
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * Setter method for grupo.
     *
     * @param aGrupo the new value for grupo
     */
    public void setGrupo(Grupo aGrupo) {
        grupo = aGrupo;
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
        if (this.getId() != that.getId()) {
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
        StringBuffer sb = new StringBuffer("[GrupoTieneDocs |");
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
