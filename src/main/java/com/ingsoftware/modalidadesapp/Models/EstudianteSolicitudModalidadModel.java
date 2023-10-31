package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante_solicitud_modalidad")
public class EstudianteSolicitudModalidadModel
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long esm_id;

    public Long getEsm_id() {
        return esm_id;
    }

    public void setEsm_id(Long esm_id) {
        this.esm_id = esm_id;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estu_id", nullable = false)
    private EstudianteModel estu_id;

    public EstudianteModel getEstu_id() {
        return estu_id;
    }

    public void setEstu_id(EstudianteModel estu_id) {
        this.estu_id = estu_id;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "solm_id", nullable = false)
    private SolicitudModalidadModel solm_id;

    public SolicitudModalidadModel getSolm_id() {
        return solm_id;
    }

    public void setSolm_id(SolicitudModalidadModel solm_id) {
        this.solm_id = solm_id;
    }
}
