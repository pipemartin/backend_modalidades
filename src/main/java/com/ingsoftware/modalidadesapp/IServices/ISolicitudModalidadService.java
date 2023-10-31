package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.SolicitudModalidadModel;
import com.ingsoftware.modalidadesapp.Repositories.ISolicitudModalidadRepository;

import java.util.List;
import java.util.Optional;

public interface ISolicitudModalidadService {

    //Consultar todo
    List<SolicitudModalidadModel> all();

    //Consultar por ID
    Optional<SolicitudModalidadModel> findById(Long id);

    //Guardar
    SolicitudModalidadModel save(SolicitudModalidadModel solicitudModalidad);

    void saveSolicitudProyecto(String pdfFormulario, Long tipoModalidad, String titulo);

    void saveSolicitudPosgrado(String pdfFormulario, Long tipoModalidad, String nombrePosgrado, String pdfPosgrado);


    void saveSolicitudOtras(String pdfFormulario, Long tipoModalidad);

    void saveSolicitudEmprendimiento(String pdfFormulario, Long tipoModalidad, Long categoria, String pdfEmprendimiento);

    void saveSolicitudPractica(String pdfFormulario, Long tipoModalidad, String pdfPractica, String pas_nombre_empresa,
                               String pas_direccion_empresa, String pas_telefono_empresa, String pas_actividad_empresa,
                               String pas_nombre_responsable, String pas_primer_apellido_responsable,
                               String pas_segundo_apellido_responsable, String pas_cargo_responsable,
                               String pas_telefono_responsable, String pas_email_responsable, Long tipe_id);

    void saveSolicitudPasantia(String pdfFormulario, Long tipoModalidad, String pas_nombre_empresa,
                               String pas_direccion_empresa, String pas_telefono_empresa, String pas_actividad_empresa,
                               String pas_nombre_responsable, String pas_primer_apellido_responsable,
                               String pas_segundo_apellido_responsable, String pas_cargo_responsable,
                               String pas_telefono_responsable, String pas_email_responsable, Long tipe_id);


}
