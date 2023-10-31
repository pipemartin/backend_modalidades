package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.FacultadModel;

import java.util.List;
import java.util.Optional;

public interface IFacultadService {

    //Consultar todo
    List<FacultadModel> all();

    //Consultar por ID
    Optional<FacultadModel> findById(Long id);

    //Guardar
    FacultadModel save(FacultadModel facultad);
}
