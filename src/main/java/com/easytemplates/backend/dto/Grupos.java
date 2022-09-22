// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="grupos")
public class Grupos implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private Long id;
    
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

    /** Default constructor. */
    public Grupos() {
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
}
