package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.EstudianteProgramaModel;

import java.util.List;
import java.util.Optional;

public interface IEstudianteProgramaService {
    //Consultar todo
    List<EstudianteProgramaModel> all();

    //Consultar por ID
    Optional<EstudianteProgramaModel> findById(Long id);

    //Guardar
    EstudianteProgramaModel save(EstudianteProgramaModel estudiantePrograma);
}
