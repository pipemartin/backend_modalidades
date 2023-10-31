package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.ModalidadPracticaModel;

import java.util.List;
import java.util.Optional;

public interface IModalidadPracticaService {

    //Consultar todo
    List<ModalidadPracticaModel> all();

    //Consultar por ID
    Optional<ModalidadPracticaModel> findById(Long id);

    //Guardar
    ModalidadPracticaModel save(ModalidadPracticaModel modalidadPractica);
}
