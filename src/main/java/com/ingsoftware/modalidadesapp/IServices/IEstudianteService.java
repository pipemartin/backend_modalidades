package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.EstudianteModel;
import com.ingsoftware.modalidadesapp.Models.EstudianteProgramaRequest;
import com.ingsoftware.modalidadesapp.Repositories.IEstudianteRepository;

import java.util.List;
import java.util.Optional;

public interface IEstudianteService {

    //Consultar todo
    List<EstudianteModel> all();

    //Consultar por ID
    Optional<EstudianteModel> findById(Long id);

    //Actualizar
    void update(Long id, EstudianteModel estudiante);

    //Guardar
    EstudianteModel save(EstudianteModel estudiante);

    void saveEstudiantePrograma(List<EstudianteProgramaRequest> datosEstudiantes);

    List<IEstudianteRepository.EstudianteProyectoProjection> findEstudianteProyecto(Long id);
}
