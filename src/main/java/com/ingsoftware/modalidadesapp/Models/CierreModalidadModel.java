package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cierre_modalidad")
public class CierreModalidadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cie_id;

    private String cie_concepto;

    @Temporal(TemporalType.DATE)
    private Date cie_fecha;

    //Getters and setters
    public Long getCie_id() {
        return cie_id;
    }

    public void setCie_id(Long cie_id) {
        this.cie_id = cie_id;
    }

    public String getCie_concepto() {
        return cie_concepto;
    }

    public void setCie_concepto(String cie_concepto) {
        this.cie_concepto = cie_concepto;
    }

    public Date getCie_fecha() {
        return cie_fecha;
    }

    public void setCie_fecha(Date cie_fecha) {
        this.cie_fecha = cie_fecha;
    }

    //Relación Tabla CierreModalidadModel -> SolicitudModalidadModel
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
