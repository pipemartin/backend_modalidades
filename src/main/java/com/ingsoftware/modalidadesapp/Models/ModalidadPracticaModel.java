package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "pratica")
public class ModalidadPracticaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pra_id;

    private String pra_contrato_pdf;

    //Getters and Setters
    public Long getPra_id() {
        return pra_id;
    }

    public void setPra_id(Long pra_id) {
        this.pra_id = pra_id;
    }

    public String getPra_contrato_pdf() {
        return pra_contrato_pdf;
    }

    public void setPra_contrato_pdf(String pra_contrato_pdf) {
        this.pra_contrato_pdf = pra_contrato_pdf;
    }

    //Relación Tabla ModalidadPracticaModel -> SolicitudModalidadModel
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
