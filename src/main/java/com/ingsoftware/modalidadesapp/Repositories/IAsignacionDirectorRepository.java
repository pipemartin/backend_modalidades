package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.AsignacionDirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IAsignacionDirectorRepository extends JpaRepository<AsignacionDirectorModel, Long > {

    public interface Modalidades_solicitudProjection {
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
        String getCon_concepto();
        Date getCon_fecha();
    }

    //todo Proyecto
    public interface Proyecto_solicitudProjection extends Modalidades_solicitudProjection {
        String getPro_titulo();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, proyecto_grado.pro_titulo, \n" +
            "solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, \n" +
            "estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono, \n" +
            "concepto.con_concepto, concepto.con_fecha\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join proyecto_grado on solicitud_modalidad.solm_id = proyecto_grado.solm_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "where solicitud_modalidad.mod_id = 1\n" +
            "AND solicitud_modalidad_estado.est_id = 1\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from asignacion_director)", nativeQuery = true)
    List<Proyecto_solicitudProjection> findProyecto_solicitud();

    //todo Pasantía
    public interface Pasantia_solicitudProjection extends Modalidades_solicitudProjection {
        String getPas_nombre_empresa();
        String getPas_direccion_empresa();
        String getPas_telefono_empresa();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, empresa.pas_nombre_empresa, empresa.pas_direccion_empresa, \n" +
            "empresa.pas_telefono_empresa, concepto.con_concepto, concepto.con_fecha\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join empresa on solicitud_modalidad.solm_id = empresa.solm_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "where solicitud_modalidad.mod_id = 2\n" +
            "AND solicitud_modalidad_estado.est_id = 1\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from asignacion_director)", nativeQuery = true)
    List<Pasantia_solicitudProjection> findPasantia_solicitud();

    //todo Postgrado
    public interface Postgrado_solicitudProjection extends Modalidades_solicitudProjection {
        String getPos_nombre_posgrado();
        String getPos_pdf();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, posgrado.pos_nombre_posgrado, posgrado.pos_pdf, \n" +
            "concepto.con_concepto, concepto.con_fecha\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join posgrado on solicitud_modalidad.solm_id = posgrado.solm_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "where solicitud_modalidad.mod_id = 3\n" +
            "AND solicitud_modalidad_estado.est_id = 1\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from asignacion_director)", nativeQuery = true)
    List<Postgrado_solicitudProjection> findPostgrado_solicitud();

    //todo Emprendimiento
    public interface Emprendimiento_solicitudProjection extends Modalidades_solicitudProjection {
        String getEmp_categoria_pdf();
        String getCat_nombre();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, emprendimiento.emp_categoria_pdf, \n" +
            "categoria.cat_nombre, concepto.con_concepto, concepto.con_fecha\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join emprendimiento on solicitud_modalidad.solm_id = emprendimiento.solm_id\n" +
            "inner join categoria on emprendimiento.cat_id = categoria.cat_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "where solicitud_modalidad.mod_id = 4\n" +
            "AND solicitud_modalidad_estado.est_id = 1\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from asignacion_director)", nativeQuery = true)
    List<Emprendimiento_solicitudProjection> findEmprendimiento_solicitud();

    //todo Práctica
    public interface Practica_solicitudProjection extends Modalidades_solicitudProjection {
        String getPra_contrato_pdf();
        String getPas_nombre_empresa();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, pratica.pra_contrato_pdf, \n" +
            "empresa.pas_nombre_empresa, concepto.con_concepto, concepto.con_fecha\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join pratica on solicitud_modalidad_estado.solm_id = pratica.solm_id\n" +
            "inner join empresa on solicitud_modalidad.solm_id = empresa.solm_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "where solicitud_modalidad.mod_id = 9\n" +
            "AND solicitud_modalidad_estado.est_id = 1\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from asignacion_director)", nativeQuery = true)
    List<Practica_solicitudProjection> findPractica_solicitud();

    //todo Semillero, Producción, Seminario, Portafolio
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, estudiante.estu_primer_apellido,\n" +
            "estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id,\n" +
            "solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono,\n" +
            "concepto.con_concepto, concepto.con_fecha\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "where solicitud_modalidad.mod_id = :id\n" +
            "AND solicitud_modalidad_estado.est_id = 1\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from asignacion_director)", nativeQuery = true)
    List<Modalidades_solicitudProjection> findModalidadesOtras_solicitud(@Param("id") Long id);
}
