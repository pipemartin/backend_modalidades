package com.ingsoftware.modalidadesapp.Models;

public class SolicitudEmprendimientoRequest {
    private String pdfFormulario;
    private Long tipoModalidad;
    private Long categoria;
    private String pdfEmprendimiento;

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

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public String getPdfEmprendimiento() {
        return pdfEmprendimiento;
    }

    public void setPdfEmprendimiento(String pdfEmprendimiento) {
        this.pdfEmprendimiento = pdfEmprendimiento;
    }
}
