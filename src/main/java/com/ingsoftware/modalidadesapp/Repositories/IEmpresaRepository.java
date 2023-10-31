package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmpresaRepository extends JpaRepository<EmpresaModel, Long> {
    public interface Empresa_Projection {
        Long getPas_id();
        String getPas_actividad_empresa();
        String getPas_cargo_responsable();
        String getPas_direccion_empresa();
        String getPas_email_responsable();
        String getPas_nombre_empresa();
        String getPas_nombre_responsable();
        String getPas_primer_apellido_responsable();
        String getPas_segundo_apellido_responsable();
        String getPas_telefono_empresa();
        String getPas_telefono_responsable();
        String getTipe_nombre();
        String getMod_nombre();
    }
    @Query(value = "select distinct empresa.pas_id, empresa.pas_actividad_empresa, empresa.pas_cargo_responsable, \n" +
            "empresa.pas_direccion_empresa, empresa.pas_email_responsable, empresa.pas_nombre_empresa, \n" +
            "empresa.pas_nombre_responsable, empresa.pas_primer_apellido_responsable, \n" +
            "empresa.pas_segundo_apellido_responsable, empresa.pas_telefono_empresa, empresa.pas_telefono_responsable, \n" +
            "tipo_empresa.tipe_nombre, modalidad.mod_nombre\n" +
            "from empresa\n" +
            "inner join solicitud_modalidad on empresa.solm_id = solicitud_modalidad.solm_id\n" +
            "inner join modalidad on solicitud_modalidad.mod_id = modalidad.mod_id\n" +
            "inner join tipo_empresa on empresa.tipe_id = tipo_empresa.tipe_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "where solicitud_modalidad_estado.est_id not in (2, 7)", nativeQuery = true)
    List<Empresa_Projection> findEmpresa();
}
