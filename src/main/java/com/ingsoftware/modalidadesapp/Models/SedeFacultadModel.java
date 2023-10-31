package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "sede_facultad")
public class SedeFacultadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sefa_id;

    public Long getSefa_id() {
        return sefa_id;
    }

    public void setSefa_id(Long sefa_id) {
        this.sefa_id = sefa_id;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sed_id", nullable = false)
    private SedeModel sed_id;

    public SedeModel getSed_id() {
        return sed_id;
    }

    public void setSed_id(SedeModel sed_id) {
        this.sed_id = sed_id;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "fac_id", nullable = false)
    private FacultadModel fac_id;

    public FacultadModel getFac_id() {
        return fac_id;
    }

    public void setFac_id(FacultadModel fac_id) {
        this.fac_id = fac_id;
    }
}
