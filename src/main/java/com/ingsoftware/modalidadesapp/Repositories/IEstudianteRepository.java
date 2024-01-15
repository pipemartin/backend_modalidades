package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.EstudianteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IEstudianteRepository extends JpaRepository<EstudianteModel, Long> {



    public interface EstudianteProyectoProjection {
        String getSolm_form_pdf();
        String getEsp_email();
        String getEstu_identificacion();
        String getEstu_telefono();

    }

    public interface EstudianteDelete {
        Long getEstu_id();
    }

    public interface EstudianteProyecto {

        String getSolm_id();
        String getSolm_form_pdf();
        String getEsp_codigo();
        Date getSest_fecha();
        String getEstu_nombre();
        String getEstu_primer_apellido();
        String getEstu_segundo_apellido();
        String getEst_nombre();
        String getEsp_email();
        String getEstu_identificacion();
        String getEstu_telefono();
        Long getEstu_id();
    }





    @Query(value = "select solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "where estudiante.estu_id = :id", nativeQuery = true)
    List<EstudianteProyectoProjection> findEstudianteProyecto(@Param("id") Long id);


    @Query(value = "select solicitud_modalidad.solm_id,estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_codigo, solicitud_modalidad_estado.sest_fecha, estudiante.estu_nombre, estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, estado.est_nombre, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "where estudiante_programa.esp_codigo = :codigo AND solicitud_modalidad_estado.est_id IN (1, 2, 3, 4, 5, 6, 7)", nativeQuery = true)
    List<EstudianteProyecto> findEstudiante(@Param("codigo") String id);

    @Query(value = "select estudiante.estu_id\n" +
            "from estudiante_programa\n" +
            "inner join estudiante on estudiante_programa.estu_id = estudiante.estu_id\n" +
            "where estudiante_programa.esp_codigo = :codigo", nativeQuery = true)
    List<EstudianteDelete> findEstudianteDelete(@Param("codigo") String id);


    @Query(value = "SELECT estu_id FROM estudiante ORDER BY estu_id DESC LIMIT 1", nativeQuery = true)
    Long findLastInsertedId();
}
