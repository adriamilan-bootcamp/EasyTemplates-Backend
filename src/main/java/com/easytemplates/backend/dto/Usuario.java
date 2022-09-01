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
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="usuarios")
public class Usuario implements Serializable {

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
    @Column(nullable=false, length=255)
    private String email;
    @Column(length=255)
    private String firma;
    @Column(nullable=false, length=45)
    private String password;
    @Column(length=255)
    private String token;
    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private Set<UsuarioTieneDocs> usuarioTieneDocs;
    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private Set<UsuarioPerteneceGrupos> usuarioPerteneceGrupos;
    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private Set<Grupo> grupo;

    /** Default constructor. */
    public Usuario() {
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
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for firma.
     *
     * @return the current value of firma
     */
    public String getFirma() {
        return firma;
    }

    /**
     * Setter method for firma.
     *
     * @param aFirma the new value for firma
     */
    public void setFirma(String aFirma) {
        firma = aFirma;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for token.
     *
     * @return the current value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for token.
     *
     * @param aToken the new value for token
     */
    public void setToken(String aToken) {
        token = aToken;
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
     * Access method for grupo.
     *
     * @return the current value of grupo
     */
    public Set<Grupo> getGrupo() {
        return grupo;
    }

    /**
     * Setter method for grupo.
     *
     * @param aGrupo the new value for grupo
     */
    public void setGrupo(Set<Grupo> aGrupo) {
        grupo = aGrupo;
    }

    /**
     * Compares the key for this instance with another Usuario.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Usuario and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Usuario)) {
            return false;
        }
        Usuario that = (Usuario) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Usuario.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Usuario)) return false;
        return this.equalKeys(other) && ((Usuario)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Usuario |");
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
