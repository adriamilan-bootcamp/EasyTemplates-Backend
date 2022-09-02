// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

@Entity(name="imagenes")
public class Imagen implements Serializable {

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
    @Column(length=255)
    private String src;
    @Column(name="fecha_creacion")
    private LocalDateTime fechaCreacion;
    @OneToMany(mappedBy="imagen")
    private Set<GrupoTieneDocs> grupoTieneDocs;
    @OneToMany(mappedBy="imagen")
    private Set<UsuarioTieneDocs> usuarioTieneDocs;
    @OneToMany(mappedBy="imagen")
    private Set<PlantillaUsaImagenes> plantillaUsaImagenes;

    /** Default constructor. */
    public Imagen() {
        super();
        // Date
        LocalDateTime myDateObj = LocalDateTime.now();
        this.fechaCreacion = myDateObj;
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
     * Access method for grupoTieneDocs.
     *
     * @return the current value of grupoTieneDocs
     */
    public Set<GrupoTieneDocs> getGrupoTieneDocs() {
        return grupoTieneDocs;
    }

    /**
     * Setter method for grupoTieneDocs.
     *
     * @param aGrupoTieneDocs the new value for grupoTieneDocs
     */
    public void setGrupoTieneDocs(Set<GrupoTieneDocs> aGrupoTieneDocs) {
        grupoTieneDocs = aGrupoTieneDocs;
    }

    /**
     * Access method for usuarioTieneDocs.
     *
     * @return the current value of usuarioTieneDocs
     */
    public Set<UsuarioTieneDocs> getUsuarioTieneDocs() {
        return usuarioTieneDocs;
    }

    /**
     * Setter method for usuarioTieneDocs.
     *
     * @param aUsuarioTieneDocs the new value for usuarioTieneDocs
     */
    public void setUsuarioTieneDocs(Set<UsuarioTieneDocs> aUsuarioTieneDocs) {
        usuarioTieneDocs = aUsuarioTieneDocs;
    }

    /**
     * Access method for plantillaUsaImagenes.
     *
     * @return the current value of plantillaUsaImagenes
     */
    public Set<PlantillaUsaImagenes> getPlantillaUsaImagenes() {
        return plantillaUsaImagenes;
    }

    /**
     * Setter method for plantillaUsaImagenes.
     *
     * @param aPlantillaUsaImagenes the new value for plantillaUsaImagenes
     */
    public void setPlantillaUsaImagenes(Set<PlantillaUsaImagenes> aPlantillaUsaImagenes) {
        plantillaUsaImagenes = aPlantillaUsaImagenes;
    }

    /**
     * Compares the key for this instance with another Imagen.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Imagen and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Imagen)) {
            return false;
        }
        Imagen that = (Imagen) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Imagen.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Imagen)) return false;
        return this.equalKeys(other) && ((Imagen)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Imagen |");
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
