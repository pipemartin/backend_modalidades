package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "sede")
public class SedeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sed_id;

    private String sed_nombre;

    //Getters and Setters
    public Long getSed_id() {
        return sed_id;
    }

    public void setSed_id(Long sed_id) {
        this.sed_id = sed_id;
    }

    public String getSed_nombre() {
        return sed_nombre;
    }

    public void setSed_nombre(String sed_nombre) {
        this.sed_nombre = sed_nombre;
    }

}
