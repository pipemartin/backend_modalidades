package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "programa")
public class ProgramaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pro_id;

    private String pro_nombre;

    //Getters and Setters
    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public FacultadModel getFac_id() {
        return fac_id;
    }

    public void setFac_id(FacultadModel fac_id) {
        this.fac_id = fac_id;
    }

    //Relación Tabla  ProgramaModel -> FacultadModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "fac_id", nullable = false)
    private FacultadModel fac_id;

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

}
