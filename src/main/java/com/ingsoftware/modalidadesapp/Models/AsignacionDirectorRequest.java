package com.ingsoftware.modalidadesapp.Models;

import java.util.Date;

public class AsignacionDirectorRequest {
    private Long solm_id;
    private Date asig_fecha_final;
    private Date asig_fecha_inicial;
    private Long dir_id;

    public Long getSolm_id() {
        return solm_id;
    }

    public void setSolm_id(Long solm_id) {
        this.solm_id = solm_id;
    }

    public Date getAsig_fecha_final() {
        return asig_fecha_final;
    }

    public void setAsig_fecha_final(Date asig_fecha_final) {
        this.asig_fecha_final = asig_fecha_final;
    }

    public Date getAsig_fecha_inicial() {
        return asig_fecha_inicial;
    }

    public void setAsig_fecha_inicial(Date asig_fecha_inicial) {
        this.asig_fecha_inicial = asig_fecha_inicial;
    }

    public Long getDir_id() {
        return dir_id;
    }

    public void setDir_id(Long dir_id) {
        this.dir_id = dir_id;
    }
}
