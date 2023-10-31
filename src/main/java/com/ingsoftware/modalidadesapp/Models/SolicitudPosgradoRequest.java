package com.ingsoftware.modalidadesapp.Models;

public class SolicitudPosgradoRequest {
    private String pdfFormulario;
    private Long tipoModalidad;

    private String nombrePosgrado;

    private String pdfPosgrado;

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

    public String getNombrePosgrado() {
        return nombrePosgrado;
    }

    public void setNombrePosgrado(String nombrePosgrado) {
        this.nombrePosgrado = nombrePosgrado;
    }

    public String getPdfPosgrado() {
        return pdfPosgrado;
    }

    public void setPdfPosgrado(String pdfPosgrado) {
        this.pdfPosgrado = pdfPosgrado;
    }
}
