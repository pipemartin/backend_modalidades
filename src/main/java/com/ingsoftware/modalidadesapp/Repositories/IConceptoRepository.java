package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.ConceptoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IConceptoRepository extends JpaRepository<ConceptoModel, Long> {

    public interface modalidades_solicitudProjection {
        Long getSolm_id();
        String getEsp_codigo();
        String getEstu_nombre();
        String getEstu_primer_apellido();
        String getEstu_segundo_apellido();
        Date getSest_fecha();
        String getEst_nombre();
        Long getEstu_id();
        String getSolm_form_pdf();
        String getEsp_email();
        String getEstu_identificacion();
        String getEstu_telefono();
    }

    //todo Proyecto
    public interface proyecto_solicitudProjection extends modalidades_solicitudProjection{
        String getPro_titulo();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, estudiante.estu_primer_apellido, \n" +
            "estudiante.estu_segundo_apellido, proyecto_grado.pro_titulo, solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id,\n" +
            "solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join proyecto_grado on solicitud_modalidad.solm_id = proyecto_grado.solm_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "where solicitud_modalidad.mod_id = 1\n" +
            "AND solicitud_modalidad.solm_id IN (\n" +
            "    SELECT solm_id\n" +
            "    FROM solicitud_modalidad_estado\n" +
            "    GROUP BY solm_id\n" +
            "    HAVING COUNT(*) = 1\n" +
            ")", nativeQuery = true)
    List<proyecto_solicitudProjection > findProyecto_solicitud();

    //todo Pasantia
    public interface pasantia_solicitudProjection extends modalidades_solicitudProjection{
        String getPas_nombre_empresa();
        String getPas_direccion_empresa();
        String getPas_telefono_empresa();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, estudiante.estu_primer_apellido, \n" +
            "estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id, \n" +
            "solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono,\n" +
            "empresa.pas_nombre_empresa, empresa.pas_direccion_empresa, empresa.pas_telefono_empresa \n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join empresa on solicitud_modalidad.solm_id = empresa.solm_id\n" +
            "where solicitud_modalidad.mod_id = 2\n" +
            "AND solicitud_modalidad.solm_id IN (\n" +
            "SELECT solm_id\n" +
            "FROM solicitud_modalidad_estado\n" +
            "GROUP BY solm_id\n" +
            "HAVING COUNT(*) = 1)", nativeQuery = true)
    List<pasantia_solicitudProjection > findPasantia_solicitud();

    //todo Postgrado
    public interface postgrado_solicitudProjection extends modalidades_solicitudProjection{
        String getPos_nombre_posgrado();
        String getPos_pdf();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, estudiante.estu_primer_apellido, \n" +
            "estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id, \n" +
            "solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono,\n" +
            "posgrado.pos_nombre_posgrado, posgrado.pos_pdf\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join posgrado on solicitud_modalidad.solm_id = posgrado.solm_id\n" +
            "where solicitud_modalidad.mod_id = 3\n" +
            "AND solicitud_modalidad.solm_id IN (\n" +
            "SELECT solm_id\n" +
            "FROM solicitud_modalidad_estado\n" +
            "GROUP BY solm_id\n" +
            "HAVING COUNT(*) = 1)", nativeQuery = true)
    List<postgrado_solicitudProjection > findPostgrado_solicitud();

    //todo Emprendimiento
    public interface emprendimiento_solicitudProjection extends modalidades_solicitudProjection{
        String getEmp_categoria_pdf();
        String getCat_nombre();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, estudiante.estu_primer_apellido, \n" +
            "estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id, \n" +
            "solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono,\n" +
            "emprendimiento.emp_categoria_pdf, categoria.cat_nombre\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join emprendimiento on solicitud_modalidad.solm_id = emprendimiento.solm_id\n" +
            "inner join categoria on emprendimiento.cat_id = categoria.cat_id\n" +
            "where solicitud_modalidad.mod_id = 4\n" +
            "AND solicitud_modalidad.solm_id IN (\n" +
            "SELECT solm_id\n" +
            "FROM solicitud_modalidad_estado\n" +
            "GROUP BY solm_id\n" +
            "HAVING COUNT(*) = 1)", nativeQuery = true)
    List<emprendimiento_solicitudProjection > findEmprendimiento_solicitud();

    //todo Práctica
    public interface practica_solicitudProjection extends modalidades_solicitudProjection{
        String getPra_contrato_pdf();
        String getPas_nombre_empresa();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, estudiante.estu_primer_apellido, \n" +
            "estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id, \n" +
            "solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono,\n" +
            "pratica.pra_contrato_pdf, empresa.pas_nombre_empresa\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join pratica on solicitud_modalidad_estado.solm_id = pratica.solm_id\n" +
            "inner join empresa on solicitud_modalidad.solm_id = empresa.solm_id\n" +
            "where solicitud_modalidad.mod_id = 9\n" +
            "AND solicitud_modalidad.solm_id IN (\n" +
            "SELECT solm_id\n" +
            "FROM solicitud_modalidad_estado\n" +
            "GROUP BY solm_id\n" +
            "HAVING COUNT(*) = 1)", nativeQuery = true)
    List<practica_solicitudProjection > findPractica_solicitud();

    //todo Semillero, portafolio, produccion, seminario
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, estudiante.estu_primer_apellido, \n" +
            "estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id, \n" +
            "solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "where solicitud_modalidad.mod_id = :id\n" +
            "AND solicitud_modalidad.solm_id IN (\n" +
            "SELECT solm_id\n" +
            "FROM solicitud_modalidad_estado\n" +
            "GROUP BY solm_id\n" +
            "HAVING COUNT(*) = 1)", nativeQuery = true)
    List<modalidades_solicitudProjection > findModalidadesOtras_solicitud(@Param("id") Long id);

}



