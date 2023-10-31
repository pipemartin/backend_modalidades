package com.ingsoftware.modalidadesapp.Models;

public class EstudianteProgramaRequest {
    private String eps;
    private String identificacion;
    private String nombre;
    private String nombreAcud;
    private String primerApell;
    private String segundoApell;
    private String telefono;
    private String telefoAcud;
    private String codigo;
    private String email;
    private Long programa;
    private Long sede;

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAcud() {
        return nombreAcud;
    }

    public void setNombreAcud(String nombreAcud) {
        this.nombreAcud = nombreAcud;
    }

    public String getPrimerApell() {
        return primerApell;
    }

    public void setPrimerApell(String primerApell) {
        this.primerApell = primerApell;
    }

    public String getSegundoApell() {
        return segundoApell;
    }

    public void setSegundoApell(String segundoApell) {
        this.segundoApell = segundoApell;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefoAcud() {
        return telefoAcud;
    }

    public void setTelefoAcud(String telefoAcud) {
        this.telefoAcud = telefoAcud;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPrograma() {
        return programa;
    }

    public void setPrograma(Long programa) {
        this.programa = programa;
    }

    public Long getSede() {
        return sede;
    }

    public void setSede(Long sede) {
        this.sede = sede;
    }
}
