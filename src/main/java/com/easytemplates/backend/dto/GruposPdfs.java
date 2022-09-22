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

@Entity(name="grupos_pdfs")
public class GruposPdfs implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="grupo")
    private Grupos grupos;
    
    @ManyToOne
    @JoinColumn(name="pdf")
    private Pdfs pdfs;

    /** Default constructor. */
    public GruposPdfs() {
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
     * Access method for grupos.
     *
     * @return the current value of grupos
     */
    public Grupos getGrupos() {
        return grupos;
    }

    /**
     * Setter method for grupos.
     *
     * @param aGrupos the new value for grupos
     */
    public void setGrupos(Grupos aGrupos) {
        grupos = aGrupos;
    }

    /**
     * Access method for pdfs.
     *
     * @return the current value of pdfs
     */
    public Pdfs getPdfs() {
        return pdfs;
    }

    /**
     * Setter method for pdfs.
     *
     * @param aPdfs the new value for pdfs
     */
    public void setPdfs(Pdfs aPdfs) {
        pdfs = aPdfs;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[GruposPdfs |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }
}
