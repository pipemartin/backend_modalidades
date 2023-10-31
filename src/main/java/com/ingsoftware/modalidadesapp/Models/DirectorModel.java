package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "director")
public class DirectorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dir_id;

    private String dir_nombre;
    private String dir_identificacion;
    private String dir_primer_apellido;
    private String dir_segundo_apellido;
    private String dir_telefono;
    private String dir_email;
    private String dir_estado;

    public Long getDir_id() {
        return dir_id;
    }

    public void setDir_id(Long dir_id) {
        this.dir_id = dir_id;
    }

    public String getDir_nombre() {
        return dir_nombre;
    }

    public void setDir_nombre(String dir_nombre) {
        this.dir_nombre = dir_nombre;
    }

    public String getDir_identificacion() {
        return dir_identificacion;
    }

    public void setDir_identificacion(String dir_identificacion) {
        this.dir_identificacion = dir_identificacion;
    }

    public String getDir_primer_apellido() {
        return dir_primer_apellido;
    }

    public void setDir_primer_apellido(String dir_primer_apellido) {
        this.dir_primer_apellido = dir_primer_apellido;
    }

    public String getDir_segundo_apellido() {
        return dir_segundo_apellido;
    }

    public void setDir_segundo_apellido(String dir_segundo_apellido) {
        this.dir_segundo_apellido = dir_segundo_apellido;
    }

    public String getDir_telefono() {
        return dir_telefono;
    }

    public void setDir_telefono(String dir_telefono) {
        this.dir_telefono = dir_telefono;
    }

    public String getDir_email() {
        return dir_email;
    }

    public void setDir_email(String dir_email) {
        this.dir_email = dir_email;
    }

    public String getDir_estado() {
        return dir_estado;
    }

    public void setDir_estado(String dir_estado) {
        this.dir_estado = dir_estado;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pro_id", nullable = false)
    private ProgramaModel pro_id;

    public ProgramaModel getPro_id() {
        return pro_id;
    }

    public void setPro_id(ProgramaModel pro_id) {
        this.pro_id = pro_id;
    }
}
