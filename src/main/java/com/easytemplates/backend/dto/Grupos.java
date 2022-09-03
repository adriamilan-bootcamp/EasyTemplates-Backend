// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="grupos")
public class Grupos implements Serializable {

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
    @Column(nullable=false, length=255)
    private String nombre;
    @OneToMany(mappedBy="grupos")
    private Set<UsuariosPertenecenGrupos> usuariosPertenecenGrupos;
    @ManyToOne
    @JoinColumn(name="admin")
    private Usuarios usuarios;
    @OneToMany(mappedBy="grupos")
    private Set<GruposImagenes> gruposImagenes;
    @OneToMany(mappedBy="grupos")
    private Set<GruposPdfs> gruposPdfs;
    @OneToMany(mappedBy="grupos")
    private Set<GruposPlantillas> gruposPlantillas;
    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuarios usuarios2;

    /** Default constructor. */
    public Grupos() {
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
     * Access method for nombre.
     *
     * @return the current value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setNombre(String aNombre) {
        nombre = aNombre;
    }

    /**
     * Access method for usuariosPertenecenGrupos.
     *
     * @return the current value of usuariosPertenecenGrupos
     */
    public Set<UsuariosPertenecenGrupos> getUsuariosPertenecenGrupos() {
        return usuariosPertenecenGrupos;
    }

    /**
     * Setter method for usuariosPertenecenGrupos.
     *
     * @param aUsuariosPertenecenGrupos the new value for usuariosPertenecenGrupos
     */
    public void setUsuariosPertenecenGrupos(Set<UsuariosPertenecenGrupos> aUsuariosPertenecenGrupos) {
        usuariosPertenecenGrupos = aUsuariosPertenecenGrupos;
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
     * Access method for gruposImagenes.
     *
     * @return the current value of gruposImagenes
     */
    public Set<GruposImagenes> getGruposImagenes() {
        return gruposImagenes;
    }

    /**
     * Setter method for gruposImagenes.
     *
     * @param aGruposImagenes the new value for gruposImagenes
     */
    public void setGruposImagenes(Set<GruposImagenes> aGruposImagenes) {
        gruposImagenes = aGruposImagenes;
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
     * Access method for gruposPlantillas.
     *
     * @return the current value of gruposPlantillas
     */
    public Set<GruposPlantillas> getGruposPlantillas() {
        return gruposPlantillas;
    }

    /**
     * Setter method for gruposPlantillas.
     *
     * @param aGruposPlantillas the new value for gruposPlantillas
     */
    public void setGruposPlantillas(Set<GruposPlantillas> aGruposPlantillas) {
        gruposPlantillas = aGruposPlantillas;
    }

    /**
     * Access method for usuarios2.
     *
     * @return the current value of usuarios2
     */
    public Usuarios getUsuarios2() {
        return usuarios2;
    }

    /**
     * Setter method for usuarios2.
     *
     * @param aUsuarios2 the new value for usuarios2
     */
    public void setUsuarios2(Usuarios aUsuarios2) {
        usuarios2 = aUsuarios2;
    }

    /**
     * Compares the key for this instance with another Grupos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Grupos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Grupos)) {
            return false;
        }
        Grupos that = (Grupos) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Grupos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Grupos)) return false;
        return this.equalKeys(other) && ((Grupos)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Grupos |");
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
