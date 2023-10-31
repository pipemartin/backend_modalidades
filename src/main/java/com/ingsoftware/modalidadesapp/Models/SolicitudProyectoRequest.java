package com.ingsoftware.modalidadesapp.Models;

public class SolicitudProyectoRequest {
    private String pdfFormulario;
    private Long tipoModalidad;
    private String titulo;

    public String getPdfFormulario() {
        return pdfFormulario;
    }

    public void setPdfFormulario(String pdfFormulario) {
        this.pdfFormulario = pdfFormulario;
    }

    public Long getTipoModalidad() {
        return tipoModalidad;
    }

    public void setTipoModalidad(Long tipoModalidad) {
        this.tipoModalidad = tipoModalidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
