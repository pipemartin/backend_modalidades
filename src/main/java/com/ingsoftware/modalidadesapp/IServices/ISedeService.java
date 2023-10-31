package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.SedeModel;

import java.util.List;
import java.util.Optional;

public interface ISedeService {

    //Consultar todo
    List<SedeModel> all();

    //Consultar por ID
    Optional<SedeModel> findById(Long id);

    //Guardar
    SedeModel save(SedeModel sede);
}
