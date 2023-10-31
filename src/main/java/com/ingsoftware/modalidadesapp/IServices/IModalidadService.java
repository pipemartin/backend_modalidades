package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.ModalidadModel;

import java.util.List;
import java.util.Optional;

public interface IModalidadService {

    //Consultar todo
    List<ModalidadModel> all();

    //Consultar por ID
    Optional<ModalidadModel> findById(Long id);

    //Guardar
    ModalidadModel save(ModalidadModel modalidad);
}
