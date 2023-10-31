package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
public class EstudianteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estu_id;

    private String estu_nombre;

    private String estu_identificacion;
    private String estu_primer_apellido;
    private String estu_segundo_apellido;
    private String estu_telefono;
    private String estu_eps;
    private String estu_nombre_acudiente;
    private String estu_telefono_acudiente;

    //Getters and Setters


    public Long getEstu_id() {
        return estu_id;
    }

    public void setEstu_id(Long estu_id) {
        this.estu_id = estu_id;
    }

    public String getEstu_nombre() {
        return estu_nombre;
    }

    public void setEstu_nombre(String estu_nombre) {
        this.estu_nombre = estu_nombre;
    }

    public String getEstu_identificacion() {
        return estu_identificacion;
    }

    public void setEstu_identificacion(String estu_identificacion) {
        this.estu_identificacion = estu_identificacion;
    }

    public String getEstu_primer_apellido() {
        return estu_primer_apellido;
    }

    public void setEstu_primer_apellido(String estu_primer_apellido) {
        this.estu_primer_apellido = estu_primer_apellido;
    }

    public String getEstu_segundo_apellido() {
        return estu_segundo_apellido;
    }

    public void setEstu_segundo_apellido(String estu_segundo_apellido) {
        this.estu_segundo_apellido = estu_segundo_apellido;
    }

    public String getEstu_telefono() {
        return estu_telefono;
    }

    public void setEstu_telefono(String estu_telefono) {
        this.estu_telefono = estu_telefono;
    }

    public String getEstu_eps() {
        return estu_eps;
    }

    public void setEstu_eps(String estu_eps) {
        this.estu_eps = estu_eps;
    }

    public String getEstu_nombre_acudiente() {
        return estu_nombre_acudiente;
    }

    public void setEstu_nombre_acudiente(String estu_nombre_acudiente) {
        this.estu_nombre_acudiente = estu_nombre_acudiente;
    }

    public String getEstu_telefono_acudiente() {
        return estu_telefono_acudiente;
    }

    public void setEstu_telefono_acudiente(String estu_telefono_acudiente) {
        this.estu_telefono_acudiente = estu_telefono_acudiente;
    }
}
