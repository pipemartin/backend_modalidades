package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "posgrado")
public class ModalidadPosgradoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pos_id;

    private String pos_nombre_posgrado;
    private String pos_pdf;

    //Getters and Setters
    public Long getPos_id() {
        return pos_id;
    }

    public void setPos_id(Long pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_nombre_posgrado() {
        return pos_nombre_posgrado;
    }

    public void setPos_nombre_posgrado(String pos_nombre_posgrado) {
        this.pos_nombre_posgrado = pos_nombre_posgrado;
    }

    public String getPos_pdf() {
        return pos_pdf;
    }

    public void setPos_pdf(String pos_pdf) {
        this.pos_pdf = pos_pdf;
    }

    //Relación Tabla ModalidadPosgradoModel -> SolicitudModalidadModel
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
