package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.AsignacionDirectorModel;
import com.ingsoftware.modalidadesapp.Repositories.IAsignacionDirectorRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IAsignacionDirectorService {

    //todo métodos básicos (consultar todo, consultar por ID, guardar)
    List<AsignacionDirectorModel> all();
    Optional<AsignacionDirectorModel> findById(Long id);
    AsignacionDirectorModel save(AsignacionDirectorModel asignacionDirector);

    //todo Listar
    List<IAsignacionDirectorRepository.Proyecto_solicitudProjection>findProyecto_solicitud();
    List<IAsignacionDirectorRepository.Pasantia_solicitudProjection>findPasantia_solicitud();
    List<IAsignacionDirectorRepository.Postgrado_solicitudProjection>findPostgrado_solicitud();
    List<IAsignacionDirectorRepository.Emprendimiento_solicitudProjection>findEmprendimiento_solicitud();
    List<IAsignacionDirectorRepository.Practica_solicitudProjection>findPractica_solicitud();
    List<IAsignacionDirectorRepository.Modalidades_solicitudProjection>findModalidadesOtras_solicitud(Long id);

    //todo Guardar
    void saveAsignarDirector(Long solm_id, Date asig_fecha_final, Date asig_fecha_inicial, Long dir_id);

}
