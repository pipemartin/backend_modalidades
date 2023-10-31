package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "emprendimiento")
public class ModalidadEmprendimientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emp_id;

    private String emp_categoria_pdf;

    //Getters and Setters
    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_categoria_pdf() {
        return emp_categoria_pdf;
    }

    public void setEmp_categoria_pdf(String emp_categoria_pdf) {
        this.emp_categoria_pdf = emp_categoria_pdf;
    }

    //Relación Tabla  ModalidadEmprendimientoModel -> CategoriaModalidadEmprendimientoModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cat_id", nullable = false)
    private CategoriaModalidadEmprendimientoModel cat_id;

    public CategoriaModalidadEmprendimientoModel getCat_id() {
        return cat_id;
    }

    public void setCat_id(CategoriaModalidadEmprendimientoModel cat_id) {
        this.cat_id = cat_id;
    }

    //Relación Tabla ModalidadEmprendimientoModel -> SolicitudModalidadModel
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
