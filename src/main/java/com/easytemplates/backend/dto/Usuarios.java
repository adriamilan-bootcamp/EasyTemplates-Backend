// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.easytemplates.backend.security.SecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity(name="usuarios")
public class Usuarios implements Serializable, UserDetails {

	public enum Rol {
	    ADMIN,
	    USER;
	}
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    @JsonView(SecurityRole.role_admin.class)
    private Long id;
    
    @Column(nullable=false, length=255)
    @JsonView(SecurityRole.role_user.class)
    private String username;
    
    @Column(nullable=false, length=255)
    @JsonView(SecurityRole.role_user.class)
    private String email;
    
    @Column(length=255)
    @JsonView(SecurityRole.role_admin.class)
    private String firma;
    
    @Column(nullable=false, length=100)
    @JsonView(SecurityRole.role_admin.class)
    private String password;

    @OneToMany(mappedBy="usuarios")
    @JsonIgnore
    private Set<UsuariosPertenecenGrupos> usuariosPertenecenGrupos;
    
    @OneToMany(mappedBy="usuarios")
    @JsonIgnore
    private Set<Grupos> grupos;
    
    @OneToMany(mappedBy="usuario")
    @JsonIgnore
    private Set<UsuariosImagenes> usuariosImagenes;
    
    @OneToMany(mappedBy="usuarios")
    @JsonIgnore
    private Set<UsuariosPdfs> usuariosPdfs;
    
    @OneToMany(mappedBy="usuarios")
    @JsonIgnore
    private Set<UsuariosPlantillas> usuariosPlantillas;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();     
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
 
    public Set<Role> getRoles() {
        return roles;
    }
 
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
     
    public void addRole(Role role) {
        this.roles.add(role);
    }
    
    /** Default constructor. */
    public Usuarios() {
        super();
    }


	/**
     * Access method for id.
     *
     * @return the current value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(Long aId) {
        id = aId;
    }

    /**
     * Setter method for nombre.
     *
     * @param aNombre the new value for nombre
     */
    public void setUsername(String username) {
    	this.username = username;
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

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

}
