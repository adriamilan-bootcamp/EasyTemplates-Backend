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
public class Grupo implements Serializable {

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
    @OneToMany(mappedBy="grupo")
    private Set<GrupoTieneDocs> grupoTieneDocs;
    @OneToMany(mappedBy="grupo")
    private Set<UsuarioPerteneceGrupos> usuarioPerteneceGrupos;
    @ManyToOne
    @JoinColumn(name="admin")
    private Usuario usuario;

    /** Default constructor. */
    public Grupo() {
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
     * Access method for usuarioPerteneceGrupos.
     *
     * @return the current value of usuarioPerteneceGrupos
     */
    public Set<UsuarioPerteneceGrupos> getUsuarioPerteneceGrupos() {
        return usuarioPerteneceGrupos;
    }

    /**
     * Setter method for usuarioPerteneceGrupos.
     *
     * @param aUsuarioPerteneceGrupos the new value for usuarioPerteneceGrupos
     */
    public void setUsuarioPerteneceGrupos(Set<UsuarioPerteneceGrupos> aUsuarioPerteneceGrupos) {
        usuarioPerteneceGrupos = aUsuarioPerteneceGrupos;
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
     * Compares the key for this instance with another Grupo.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Grupo and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Grupo)) {
            return false;
        }
        Grupo that = (Grupo) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Grupo.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Grupo)) return false;
        return this.equalKeys(other) && ((Grupo)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Grupo |");
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
