package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.SolicitudEstadoModel;

import java.util.List;
import java.util.Optional;

public interface ISolicitudEstadoService {

    //Consultar todo
    List<SolicitudEstadoModel> all();

    //Consultar por ID
    Optional<SolicitudEstadoModel> findById(Long id);

    //Guardar
    SolicitudEstadoModel save(SolicitudEstadoModel solicitudEstado);
}
