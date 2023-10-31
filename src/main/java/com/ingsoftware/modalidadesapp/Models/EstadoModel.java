package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estado")
public class EstadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long est_id;

    private String est_nombre;

    //Getter and Setters
    public Long getEst_id() {
        return est_id;
    }

    public void setEst_id(Long est_id) {
        this.est_id = est_id;
    }

    public String getEst_nombre() {
        return est_nombre;
    }

    public void setEst_nombre(String est_nombre) {
        this.est_nombre = est_nombre;
    }
}
