package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.CierreModalidadModel;
import com.ingsoftware.modalidadesapp.Repositories.ICierreModalidadRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICierreModalidadService {

    //todo métodos básicos (consultar todo, consultar por ID, guardar)
    List<CierreModalidadModel> all();
    Optional<CierreModalidadModel> findById(Long id);
    CierreModalidadModel save(CierreModalidadModel cierre);

    //todo Listar
    List<ICierreModalidadRepository.Proyecto_solicitudProjection>findProyecto_solicitud();
    List<ICierreModalidadRepository.Proyecto_cierreProjection>findProyecto_cierre();

    List<ICierreModalidadRepository.Pasantia_solicitudProjection>findPasantia_solicitud();
    List<ICierreModalidadRepository.Pasantia_cierreProjection>findPasantia_cierre();

    List<ICierreModalidadRepository.Postgrado_solicitudProjection>findPostgrado_solicitud();
    List<ICierreModalidadRepository.Postgrado_cierreProjection>findPostgrado_cierre();

    List<ICierreModalidadRepository.Emprendimiento_solicitudProjection>findEmprendimiento_solicitud();
    List<ICierreModalidadRepository.Emprendimiento_cierreProjection>findEmprendimiento_cierre();

    List<ICierreModalidadRepository.Practica_solicitudProjection>findPractica_solicitud();
    List<ICierreModalidadRepository.Practica_cierreProjection>findPractica_cierre();

    List<ICierreModalidadRepository.Modalidades_solicitudProjection>findModalidadesOtras_solicitud(Long id);
    List<ICierreModalidadRepository.Modalidades_solicitudProjection>findModalidadesOtras_cierre(Long id);

    //todo Guardar
    void saveCierreModalidad(String cie_concepto, Long solm_id, Long est_id);

    //todo Actualizar
    void updateAsignarDirector(Long asig_id, Date asig_fecha_final, Date asig_fecha_inicial, Long dir_id);
    void updateEstadoDirector(Long asig_id);


    List<ICierreModalidadRepository.EstudiantesEjecucionProjection>findPEstudiantesEjecucion();
}
