package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaModalidadEmprendimientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id;

    private String cat_nombre;

    //Getters and Setters
    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }
}
