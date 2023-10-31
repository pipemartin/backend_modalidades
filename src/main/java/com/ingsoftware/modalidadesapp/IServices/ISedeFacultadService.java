package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.SedeFacultadModel;
import com.ingsoftware.modalidadesapp.Repositories.ISedeFacultadRepository;

import java.util.List;
import java.util.Optional;

public interface ISedeFacultadService {

    //Consultar todo
    List<SedeFacultadModel> all();

    //Consultar por ID
    Optional<SedeFacultadModel> findById(Long id);

    List<ISedeFacultadRepository.SedeFacultadProjection> findFacultadDataByIdSede(Long id);

    //Guardar
    SedeFacultadModel save(SedeFacultadModel sedeFacultadModel);
}
