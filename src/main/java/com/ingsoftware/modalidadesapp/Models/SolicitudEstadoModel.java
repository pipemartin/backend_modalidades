package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "solicitud_modalidad_estado")
public class SolicitudEstadoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sest_id;

    @Temporal(TemporalType.DATE)
    private Date sest_fecha;

    //Getters and Setters
    public Long getSest_id() {
        return sest_id;
    }

    public void setSest_id(Long sest_id) {
        this.sest_id = sest_id;
    }

    public Date getSest_fecha() {
        return sest_fecha;
    }

    public void setSest_fecha(Date sest_fecha) {
        this.sest_fecha = sest_fecha;
    }

    //Relación SolicitudEstadoModel -> SolicitudModalidadModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "solm_id", nullable = false)
    private SolicitudModalidadModel solm_id;

    public SolicitudModalidadModel getSolm_id() {
        return solm_id;
    }

    public void setSolm_id(SolicitudModalidadModel solm_id) {
        this.solm_id = solm_id;
    }

    //SolicitudEstadoModel -> EstadoModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "est_id", nullable = false)
    private EstadoModel est_id;

    public EstadoModel getEst_id() {
        return est_id;
    }

    public void setEst_id(EstadoModel est_id) {
        this.est_id = est_id;
    }
}
