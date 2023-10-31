package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.EstudianteSolicitudModalidadModel;

import java.util.List;
import java.util.Optional;

public interface IEstudianteSolicitudModalidadService {
    //Consultar todo
    List<EstudianteSolicitudModalidadModel> all();

    //Consultar por ID
    Optional<EstudianteSolicitudModalidadModel> findById(Long id);

    //Guardar
    EstudianteSolicitudModalidadModel save(EstudianteSolicitudModalidadModel estudianteSolicitudModalidad);
}
