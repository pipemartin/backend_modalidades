package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.ConceptoModel;
import com.ingsoftware.modalidadesapp.Repositories.IConceptoRepository;

import java.util.List;
import java.util.Optional;

public interface IConceptoService {

    //todo métodos básicos (consultar todo, consultar por ID, guardar)
    List<ConceptoModel> all();
    Optional<ConceptoModel> findById(Long id);
    ConceptoModel save(ConceptoModel concepto);

    //todo Listar
    List<IConceptoRepository.proyecto_solicitudProjection>findProyecto_solicitud();

    List<IConceptoRepository.pasantia_solicitudProjection>findPasantia_solicitud();

    List<IConceptoRepository.postgrado_solicitudProjection>findPostgrado_solicitud();

    List<IConceptoRepository.emprendimiento_solicitudProjection>findEmprendimiento_solicitud();

    List<IConceptoRepository.modalidades_solicitudProjection>findModalidadesOtras_solicitud(Long id);

    List<IConceptoRepository.practica_solicitudProjection>findPractica_solicitud();

    //todo Guardar
    void saveConceptoEstado(String con_concepto, Long solm_id, Long est_id);
}
