package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "proyecto_grado")
public class ModalidadProyectoGradoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pro_id;

    private String pro_titulo;

    //Getters and Setters
    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_titulo() {
        return pro_titulo;
    }

    public void setPro_titulo(String pro_titulo) {
        this.pro_titulo = pro_titulo;
    }

    //Relación Tabla ModalidadProyectoGradoModel -> SolicitudModalidadModel
    @OneToOne
    @JoinColumn(name = "solm_id")
    private SolicitudModalidadModel solicitudModalidad;

    public SolicitudModalidadModel getSolicitudModalidad() {
        return solicitudModalidad;
    }

    public void setSolicitudModalidad(SolicitudModalidadModel solicitudModalidad) {
        this.solicitudModalidad = solicitudModalidad;
    }
}
