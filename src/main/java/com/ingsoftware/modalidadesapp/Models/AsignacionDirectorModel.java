package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "asignacion_director")
public class AsignacionDirectorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asig_id;

    @Temporal(TemporalType.DATE)
    private Date asig_fecha_inicial;

    @Temporal(TemporalType.DATE)
    private Date asig_fecha_final;

    private String asig_estado;

    public Long getAsig_id() {
        return asig_id;
    }

    public void setAsig_id(Long asig_id) {
        this.asig_id = asig_id;
    }

    public Date getAsig_fecha_inicial() {
        return asig_fecha_inicial;
    }

    public void setAsig_fecha_inicial(Date asig_fecha_inicial) {
        this.asig_fecha_inicial = asig_fecha_inicial;
    }

    public Date getAsig_fecha_final() {
        return asig_fecha_final;
    }

    public void setAsig_fecha_final(Date asig_fecha_final) {
        this.asig_fecha_final = asig_fecha_final;
    }

    public String getAsig_estado() {
        return asig_estado;
    }

    public void setAsig_estado(String asig_estado) {
        this.asig_estado = asig_estado;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "dir_id", nullable = false)
    private DirectorModel dir_id;

    public DirectorModel getDir_id() {
        return dir_id;
    }

    public void setDir_id(DirectorModel dir_id) {
        this.dir_id = dir_id;
    }

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
