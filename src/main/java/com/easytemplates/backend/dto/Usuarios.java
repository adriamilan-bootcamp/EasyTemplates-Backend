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

@Entity(name="usuarios")
public class Usuarios implements Serializable {

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
    @Column(length=100)
    private String role;
    @Column(length=255)
    private String firma;
    @Column(nullable=false, length=45)
    private String password;
    @Column(length=255)
    private String token;
    @OneToMany(mappedBy="usuarios")
    private Set<UsuariosPertenecenGrupos> usuariosPertenecenGrupos;
    @OneToMany(mappedBy="usuarios")
    private Set<Grupos> grupos;
    @OneToMany(mappedBy="usuarios")
    private Set<UsuariosImagenes> usuariosImagenes;
    @OneToMany(mappedBy="usuarios")
    private Set<UsuariosPdfs> usuariosPdfs;
    @OneToMany(mappedBy="usuarios")
    private Set<UsuariosPlantillas> usuariosPlantillas;

    /** Default constructor. */
    public Usuarios() {
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
     * Access method for role.
     *
     * @return the current value of role
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter method for role.
     *
     * @param aRole the new value for role
     */
    public void setRole(String aRole) {
        role = aRole;
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
     * Access method for grupos.
     *
     * @return the current value of grupos
     */
    public Set<Grupos> getGrupos() {
        return grupos;
    }

    /**
     * Setter method for grupos.
     *
     * @param aGrupos the new value for grupos
     */
    public void setGrupos(Set<Grupos> aGrupos) {
        grupos = aGrupos;
    }

    /**
     * Access method for usuariosImagenes.
     *
     * @return the current value of usuariosImagenes
     */
    public Set<UsuariosImagenes> getUsuariosImagenes() {
        return usuariosImagenes;
    }

    /**
     * Setter method for usuariosImagenes.
     *
     * @param aUsuariosImagenes the new value for usuariosImagenes
     */
    public void setUsuariosImagenes(Set<UsuariosImagenes> aUsuariosImagenes) {
        usuariosImagenes = aUsuariosImagenes;
    }

    /**
     * Access method for usuariosPdfs.
     *
     * @return the current value of usuariosPdfs
     */
    public Set<UsuariosPdfs> getUsuariosPdfs() {
        return usuariosPdfs;
    }

    /**
     * Setter method for usuariosPdfs.
     *
     * @param aUsuariosPdfs the new value for usuariosPdfs
     */
    public void setUsuariosPdfs(Set<UsuariosPdfs> aUsuariosPdfs) {
        usuariosPdfs = aUsuariosPdfs;
    }

    /**
     * Access method for usuariosPlantillas.
     *
     * @return the current value of usuariosPlantillas
     */
    public Set<UsuariosPlantillas> getUsuariosPlantillas() {
        return usuariosPlantillas;
    }

    /**
     * Setter method for usuariosPlantillas.
     *
     * @param aUsuariosPlantillas the new value for usuariosPlantillas
     */
    public void setUsuariosPlantillas(Set<UsuariosPlantillas> aUsuariosPlantillas) {
        usuariosPlantillas = aUsuariosPlantillas;
    }

    /**
     * Compares the key for this instance with another Usuarios.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Usuarios and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Usuarios)) {
            return false;
        }
        Usuarios that = (Usuarios) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Usuarios.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Usuarios)) return false;
        return this.equalKeys(other) && ((Usuarios)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Usuarios |");
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
