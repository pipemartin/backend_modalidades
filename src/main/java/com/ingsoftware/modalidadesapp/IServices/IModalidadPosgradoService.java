package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.ModalidadPosgradoModel;

import java.util.List;
import java.util.Optional;

public interface IModalidadPosgradoService {

    //Consultar todo
    List<ModalidadPosgradoModel> all();

    //Consultar por ID
    Optional<ModalidadPosgradoModel> findById(Long id);

    //Guardar
    ModalidadPosgradoModel save(ModalidadPosgradoModel modalidadPosgrado);
}
