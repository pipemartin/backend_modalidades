package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.EstadoModel;

import java.util.List;
import java.util.Optional;

public interface IEstadoService {
    //Consultar todo
    List<EstadoModel> all();

    //Consultar por ID
    Optional<EstadoModel> findById(Long id);

    //Guardar
    EstadoModel save(EstadoModel estado);
}
