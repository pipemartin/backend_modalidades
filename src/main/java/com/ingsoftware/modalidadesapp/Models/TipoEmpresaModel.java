package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_empresa")
public class TipoEmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipe_id;

    private String tipe_nombre;

    //Getters and Setters
    public Long getTipe_id() {
        return tipe_id;
    }

    public void setTipe_id(Long tipe_id) {
        this.tipe_id = tipe_id;
    }

    public String getTipe_nombre() {
        return tipe_nombre;
    }

    public void setTipe_nombre(String tipe_nombre) {
        this.tipe_nombre = tipe_nombre;
    }
}
