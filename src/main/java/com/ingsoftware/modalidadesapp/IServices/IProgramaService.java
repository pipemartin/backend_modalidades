package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.ProgramaModel;
import com.ingsoftware.modalidadesapp.Repositories.IProgramaRepository;

import java.util.List;
import java.util.Optional;

public interface IProgramaService {
    //Consultar todo
    List<ProgramaModel> all();

    //Consultar por ID
    Optional<ProgramaModel> findById(Long id);

    List<IProgramaRepository.FacultadProgramaProjection> findProgramaDataByIdFacultad(Long id);

    //Guardar
    ProgramaModel save(ProgramaModel programa);
}
