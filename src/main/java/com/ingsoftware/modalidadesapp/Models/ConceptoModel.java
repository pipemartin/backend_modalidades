package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "concepto")
public class ConceptoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long con_id;

    private String con_concepto;

    @Temporal(TemporalType.DATE)
    private Date con_fecha;

    //Getter and Setters

    public Long getCon_id() {
        return con_id;
    }

    public void setCon_id(Long con_id) {
        this.con_id = con_id;
    }

    public String getCon_concepto() {
        return con_concepto;
    }

    public void setCon_concepto(String con_concepto) {
        this.con_concepto = con_concepto;
    }

    public Date getCon_fecha() {
        return con_fecha;
    }

    public void setCon_fecha(Date con_fecha) {
        this.con_fecha = con_fecha;
    }

    //Relación Tabla ConceptoModel -> SolicitudModalidadModel
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
