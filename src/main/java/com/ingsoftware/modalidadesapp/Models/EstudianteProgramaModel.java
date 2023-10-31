package com.ingsoftware.modalidadesapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante_programa")
public class EstudianteProgramaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long esp_id;

    private String esp_codigo;
    private String esp_email;

    //Getters and Setters

    public Long getEsp_id() {
        return esp_id;
    }

    public void setEsp_id(Long esp_id) {
        this.esp_id = esp_id;
    }

    public String getEsp_codigo() {
        return esp_codigo;
    }

    public void setEsp_codigo(String esp_codigo) {
        this.esp_codigo = esp_codigo;
    }

    public String getEsp_email() {
        return esp_email;
    }

    public void setEsp_email(String esp_email) {
        this.esp_email = esp_email;
    }

    //Relación Tabla  EstudianteProgramaModel -> EstudianteModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estu_id", nullable = false)
    private EstudianteModel estu_id;

    public EstudianteModel getEstu_id() {
        return estu_id;
    }

    public void setEstu_id(EstudianteModel estu_id) {
        this.estu_id = estu_id;
    }

    //Relación Tabla  EstudianteProgramaModel -> SedeModel
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sed_id", nullable = false)
    private SedeModel sed_id;

    public SedeModel getSed_id() {
        return sed_id;
    }

    public void setSed_id(SedeModel sed_id) {
        this.sed_id = sed_id;
    }

    //Relación Tabla  EstudianteProgramaModel -> ProgramaModel
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
