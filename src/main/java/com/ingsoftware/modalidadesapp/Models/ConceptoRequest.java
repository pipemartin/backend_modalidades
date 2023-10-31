package com.ingsoftware.modalidadesapp.Models;

public class ConceptoRequest {
    private String con_concepto;
    private Long solm_id;
    private Long est_id;

    public String getCon_concepto() {
        return con_concepto;
    }

    public void setCon_concepto(String con_concepto) {
        this.con_concepto = con_concepto;
    }

    public Long getSolm_id() {
        return solm_id;
    }

    public void setSolm_id(Long solm_id) {
        this.solm_id = solm_id;
    }

    public Long getEst_id() {
        return est_id;
    }

    public void setEst_id(Long est_id) {
        this.est_id = est_id;
    }
}
