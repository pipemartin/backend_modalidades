package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.EstudianteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEstudianteRepository extends JpaRepository<EstudianteModel, Long> {



    public interface EstudianteProyectoProjection {
        String getSolm_form_pdf();
        String getEsp_email();
        String getEstu_identificacion();
        String getEstu_telefono();

    }


    @Query(value = "select solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "where estudiante.estu_id = :id", nativeQuery = true)
    List<EstudianteProyectoProjection> findEstudianteProyecto(@Param("id") Long id);

    @Query(value = "SELECT estu_id FROM estudiante ORDER BY estu_id DESC LIMIT 1", nativeQuery = true)
    Long findLastInsertedId();
}
