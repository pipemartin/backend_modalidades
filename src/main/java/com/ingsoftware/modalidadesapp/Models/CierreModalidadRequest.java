package com.ingsoftware.modalidadesapp.Models;

import java.util.Date;

public class CierreModalidadRequest {
    private String cie_concepto;
    private Date cie_fecha;
    private Long solm_id;
    private Long est_id;

    public String getCie_concepto() {
        return cie_concepto;
    }

    public void setCie_concepto(String cie_concepto) {
        this.cie_concepto = cie_concepto;
    }

    public Date getCie_fecha() {
        return cie_fecha;
    }

    public void setCie_fecha(Date cie_fecha) {
        this.cie_fecha = cie_fecha;
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
