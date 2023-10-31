package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "modalidad")
public class ModalidadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mod_id;

    private String mod_nombre;

    //Getters and Setters
    public Long getMod_id() {
        return mod_id;
    }

    public void setMod_id(Long mod_id) {
        this.mod_id = mod_id;
    }

    public String getMod_nombre() {
        return mod_nombre;
    }

    public void setMod_nombre(String mod_nombre) {
        this.mod_nombre = mod_nombre;
    }

}
