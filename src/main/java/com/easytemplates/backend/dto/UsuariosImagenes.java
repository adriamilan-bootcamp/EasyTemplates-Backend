// Generated with g9.

package com.easytemplates.backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="usuarios_imagenes")
public class UsuariosImagenes implements Serializable {

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
    private Long id;
    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuarios usuario;
    @ManyToOne
    @JoinColumn(name="imagen")
    private Imagenes imagenes;

    /** Default constructor. */
    public UsuariosImagenes() {
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
     * Access method for usuarios.
     *
     * @return the current value of usuarios
     */
    public Usuarios getUsuario() {
        return usuario;
    }

    /**
     * Setter method for usuarios.
     *
     * @param aUsuarios the new value for usuarios
     */
    public void setUsuario(Usuarios aUsuario) {
        usuario = aUsuario;
    }

    /**
     * Access method for imagenes.
     *
     * @return the current value of imagenes
     */
    public Imagenes getImagenes() {
        return imagenes;
    }

    /**
     * Setter method for imagenes.
     *
     * @param aImagenes the new value for imagenes
     */
    public void setImagenes(Imagenes aImagenes) {
        imagenes = aImagenes;
    }

	@Override
	public String toString() {
		return "[imagenes=" + imagenes + "]";
	}

}
