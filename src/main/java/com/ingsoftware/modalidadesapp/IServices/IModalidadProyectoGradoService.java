package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.ModalidadProyectoGradoModel;

import java.util.List;
import java.util.Optional;

public interface IModalidadProyectoGradoService {

    //Consultar todo
    List<ModalidadProyectoGradoModel> all();

    //Consultar por ID
    Optional<ModalidadProyectoGradoModel> findById(Long id);

    //Guardar
    ModalidadProyectoGradoModel save(ModalidadProyectoGradoModel modalidadProyectoGrado);
}
