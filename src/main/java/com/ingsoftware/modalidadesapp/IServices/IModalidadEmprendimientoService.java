package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.ModalidadEmprendimientoModel;

import java.util.List;
import java.util.Optional;

public interface IModalidadEmprendimientoService {

    //Consultar todo
    List<ModalidadEmprendimientoModel> all();

    //Consultar por ID
    Optional<ModalidadEmprendimientoModel> findById(Long id);

    //Guardar
    ModalidadEmprendimientoModel save(ModalidadEmprendimientoModel modalidadEmprendimiento);
}
