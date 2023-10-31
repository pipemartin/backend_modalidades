package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "solicitud_modalidad")
public class SolicitudModalidadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solm_id;

    private String solm_form_pdf;

    //Getters and Setters
    public Long getSolm_id() {
        return solm_id;
    }

    public void setSolm_id(Long solm_id) {
        this.solm_id = solm_id;
    }

    public String getSolm_form_pdf() {
        return solm_form_pdf;
    }

    public void setSolm_form_pdf(String solm_form_pdf) {
        this.solm_form_pdf = solm_form_pdf;
    }

    //Relación Tabla  SolicitudModalidadModel -> ModalidadModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "mod_id", nullable = false)
    private ModalidadModel mod_id;

    public ModalidadModel getMod_id() {
        return mod_id;
    }

    public void setMod_id(ModalidadModel mod_id) {
        this.mod_id = mod_id;
    }


    //Relación Tabla SolicitudModalidadModel -> EmpresaModel
    @OneToOne(mappedBy = "solicitudModalidad", cascade = CascadeType.ALL)
    private EmpresaModel empresa;

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

    //Relación Tabla SolicitudModalidadModel -> ModalidadEmprendimientoModel
    @OneToOne(mappedBy = "solicitudModalidad", cascade = CascadeType.ALL)
    private ModalidadEmprendimientoModel modalidadEmprendimiento;

    public ModalidadEmprendimientoModel getModalidadEmprendimiento() {
        return modalidadEmprendimiento;
    }

    public void setModalidadEmprendimiento(ModalidadEmprendimientoModel modalidadEmprendimiento) {
        this.modalidadEmprendimiento = modalidadEmprendimiento;
    }

    //Relación Tabla SolicitudModalidadModel -> ModalidadPosgradoModel
    @OneToOne(mappedBy = "solicitudModalidad", cascade = CascadeType.ALL)
    private ModalidadPosgradoModel modalidadPorsgrado;

    public ModalidadPosgradoModel getModalidadPorsgrado() {
        return modalidadPorsgrado;
    }

    public void setModalidadPorsgrado(ModalidadPosgradoModel modalidadPorsgrado) {
        this.modalidadPorsgrado = modalidadPorsgrado;
    }

    //Relación Tabla SolicitudModalidadModel -> ModalidadPracticaModel
    @OneToOne(mappedBy = "solicitudModalidad", cascade = CascadeType.ALL)
    private ModalidadPracticaModel modalidadPractica;

    public ModalidadPracticaModel getModalidadPractica() {
        return modalidadPractica;
    }

    public void setModalidadPractica(ModalidadPracticaModel modalidadPractica) {
        this.modalidadPractica = modalidadPractica;
    }

    //Relación Tabla SolicitudModalidadModel -> ModalidadProyectoGradoModel
    @OneToOne(mappedBy = "solicitudModalidad", cascade = CascadeType.ALL)
    private ModalidadProyectoGradoModel modalidadProyectoGrado;

    public ModalidadProyectoGradoModel getModalidadProyectoGrado() {
        return modalidadProyectoGrado;
    }

    public void setModalidadProyectoGrado(ModalidadProyectoGradoModel modalidadProyectoGrado) {
        this.modalidadProyectoGrado = modalidadProyectoGrado;
    }

    //Relación Tabla SolicitudModalidadModel -> ConceptoModel
    @OneToOne(mappedBy = "solicitudModalidad", cascade = CascadeType.ALL)
    private ConceptoModel concepto;

    public ConceptoModel getConcepto() {
        return concepto;
    }

    public void setConcepto(ConceptoModel concepto) {
        this.concepto = concepto;
    }

    //Relación Tabla SolicitudModalidadModel -> AsignacionDirectorModel
    @OneToOne(mappedBy = "solicitudModalidad", cascade = CascadeType.ALL)
    private AsignacionDirectorModel asignacion;

    public AsignacionDirectorModel getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(AsignacionDirectorModel asignacion) {
        this.asignacion = asignacion;
    }

    //Relación Tabla SolicitudModalidadModel -> CierreModalidadModel
    @OneToOne(mappedBy = "solicitudModalidad", cascade = CascadeType.ALL)
    private CierreModalidadModel cierre;

    public CierreModalidadModel getCierre() {
        return cierre;
    }

    public void setCierre(CierreModalidadModel cierre) {
        this.cierre = cierre;
    }
}
