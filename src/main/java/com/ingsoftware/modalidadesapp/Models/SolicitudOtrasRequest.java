package com.ingsoftware.modalidadesapp.Models;

public class SolicitudOtrasRequest {
    private String pdfFormulario;
    private Long tipoModalidad;

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
}
