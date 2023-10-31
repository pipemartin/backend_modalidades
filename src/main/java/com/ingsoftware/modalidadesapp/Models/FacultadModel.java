package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "facultad")
public class FacultadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fac_id;

    private String fac_nombre;

    //Getters and Setters
    public Long getFac_id() {
        return fac_id;
    }

    public void setFac_id(Long fac_id) {
        this.fac_id = fac_id;
    }

    public String getFac_nombre() {
        return fac_nombre;
    }

    public void setFac_nombre(String fac_nombre) {
        this.fac_nombre = fac_nombre;
    }



}
