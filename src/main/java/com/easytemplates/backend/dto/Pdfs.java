// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.easytemplates.backend.security.SecurityRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity(name="pdfs")
public class Pdfs implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    @JsonView(SecurityRole.role_user.class)
    private Long id;
    
    @Column(length=100)
    @JsonView(SecurityRole.role_user.class)
    private String titulo;
    
    @Column(length=255)
    @JsonView(SecurityRole.role_user.class)
    private String src;
    
    @Column(name="fecha_creacion")
    @JsonView(SecurityRole.role_user.class)
    private LocalDateTime fechaCreacion;
    
    @OneToMany(mappedBy="pdfs")
    @JsonIgnore
    private Set<GruposPdfs> gruposPdfs;
    
    @OneToMany(mappedBy="pdfs")
    @JsonIgnore
    private Set<UsuariosPdfs> usuariosPdfs;

    /** Default constructor. */
    public Pdfs() {
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
     * Access method for titulo.
     *
     * @return the current value of titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter method for titulo.
     *
     * @param aTitulo the new value for titulo
     */
    public void setTitulo(String aTitulo) {
        titulo = aTitulo;
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
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Pdfs |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }


}
