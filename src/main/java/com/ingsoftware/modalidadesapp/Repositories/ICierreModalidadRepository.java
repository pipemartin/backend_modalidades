package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.CierreModalidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ICierreModalidadRepository extends JpaRepository<CierreModalidadModel, Long> {

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
        Date getAsig_fecha_inicial();
        Date getAsig_fecha_final();
        String getDir_nombre();
        String getDir_primer_apellido();
        String getDir_segundo_apellido();

        Long getDir_id();
        Long getAsig_id();
    }

    //todo Proyecto
    public interface Proyecto_solicitudProjection extends Modalidades_solicitudProjection {
        String getPro_titulo();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, proyecto_grado.pro_titulo, \n" +
            "solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, \n" +
            "estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono, \n" +
            "concepto.con_concepto, concepto.con_fecha, asignacion_director.asig_fecha_inicial, asignacion_director.asig_fecha_final,\n" +
            "director.dir_nombre, director.dir_primer_apellido, director.dir_segundo_apellido, asignacion_director.dir_id, asignacion_director.asig_id\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join proyecto_grado on solicitud_modalidad.solm_id = proyecto_grado.solm_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "inner join asignacion_director on solicitud_modalidad.solm_id = asignacion_director.solm_id\n" +
            "inner join director on asignacion_director.dir_id = director.dir_id\n" +
            "where solicitud_modalidad.mod_id = 1\n" +
            "AND solicitud_modalidad_estado.est_id = 6\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from cierre_modalidad)", nativeQuery = true)
    List<Proyecto_solicitudProjection> findProyecto_solicitud();

    public interface Proyecto_cierreProjection extends Modalidades_solicitudProjection {
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
            "AND solicitud_modalidad_estado.est_id IN (2, 3, 4, 5)", nativeQuery = true)
    List<Proyecto_cierreProjection> findProyecto_cierre();

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
            "empresa.pas_telefono_empresa, concepto.con_concepto, concepto.con_fecha, asignacion_director.asig_fecha_inicial, \n" +
            "asignacion_director.asig_fecha_final, director.dir_nombre, director.dir_primer_apellido, director.dir_segundo_apellido, \n" +
            "asignacion_director.dir_id, asignacion_director.asig_id\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join empresa on solicitud_modalidad.solm_id = empresa.solm_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "inner join asignacion_director on solicitud_modalidad.solm_id = asignacion_director.solm_id\n" +
            "inner join director on asignacion_director.dir_id = director.dir_id\n" +
            "where solicitud_modalidad.mod_id = 2\n" +
            "AND solicitud_modalidad_estado.est_id = 6\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from cierre_modalidad)", nativeQuery = true)
    List<Pasantia_solicitudProjection> findPasantia_solicitud();

    public interface Pasantia_cierreProjection extends Modalidades_solicitudProjection {
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
            "AND solicitud_modalidad_estado.est_id IN (2, 3, 4, 5)", nativeQuery = true)
    List<Pasantia_cierreProjection> findPasantia_cierre();

    //todo Postgrado
    public interface Postgrado_solicitudProjection extends Modalidades_solicitudProjection {
        String getPos_nombre_posgrado();
        String getPos_pdf();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, posgrado.pos_nombre_posgrado, posgrado.pos_pdf, \n" +
            "concepto.con_concepto, concepto.con_fecha, asignacion_director.asig_fecha_inicial, asignacion_director.asig_fecha_final,\n" +
            "director.dir_nombre, director.dir_primer_apellido, director.dir_segundo_apellido, asignacion_director.dir_id, asignacion_director.asig_id\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join posgrado on solicitud_modalidad.solm_id = posgrado.solm_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "inner join asignacion_director on solicitud_modalidad.solm_id = asignacion_director.solm_id\n" +
            "inner join director on asignacion_director.dir_id = director.dir_id\n" +
            "where solicitud_modalidad.mod_id = 3\n" +
            "AND solicitud_modalidad_estado.est_id = 6\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from cierre_modalidad)", nativeQuery = true)
    List<Postgrado_solicitudProjection> findPostgrado_solicitud();

    public interface Postgrado_cierreProjection extends Modalidades_solicitudProjection {
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
            "AND solicitud_modalidad_estado.est_id IN (2, 3, 4, 5)", nativeQuery = true)
    List<Postgrado_cierreProjection> findPostgrado_cierre();

    //todo Emprendimiento
    public interface Emprendimiento_solicitudProjection extends Modalidades_solicitudProjection {
        String getEmp_categoria_pdf();
        String getCat_nombre();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, emprendimiento.emp_categoria_pdf, \n" +
            "categoria.cat_nombre, concepto.con_concepto, concepto.con_fecha, asignacion_director.asig_fecha_inicial, \n" +
            "asignacion_director.asig_fecha_final, director.dir_nombre, director.dir_primer_apellido, \n" +
            "director.dir_segundo_apellido, asignacion_director.dir_id, asignacion_director.asig_id\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join emprendimiento on solicitud_modalidad.solm_id = emprendimiento.solm_id\n" +
            "inner join categoria on emprendimiento.cat_id = categoria.cat_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "inner join asignacion_director on solicitud_modalidad.solm_id = asignacion_director.solm_id\n" +
            "inner join director on asignacion_director.dir_id = director.dir_id\n" +
            "where solicitud_modalidad.mod_id = 4\n" +
            "AND solicitud_modalidad_estado.est_id = 6\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from cierre_modalidad)", nativeQuery = true)
    List<Emprendimiento_solicitudProjection> findEmprendimiento_solicitud();

    public interface Emprendimiento_cierreProjection extends Modalidades_solicitudProjection {
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
            "AND solicitud_modalidad_estado.est_id IN (2, 3, 4, 5)", nativeQuery = true)
    List<Emprendimiento_cierreProjection> findEmprendimiento_cierre();

    //todo Práctica
    public interface Practica_solicitudProjection extends Modalidades_solicitudProjection {
        String getPra_contrato_pdf();
        String getPas_nombre_empresa();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre,\n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, pratica.pra_contrato_pdf, empresa.pas_nombre_empresa, \n" +
            "concepto.con_concepto, concepto.con_fecha, asignacion_director.asig_fecha_inicial, asignacion_director.asig_fecha_final, \n" +
            "director.dir_nombre, director.dir_primer_apellido, director.dir_segundo_apellido, asignacion_director.dir_id, asignacion_director.asig_id\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join pratica on solicitud_modalidad_estado.solm_id = pratica.solm_id\n" +
            "inner join empresa on solicitud_modalidad.solm_id = empresa.solm_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "inner join asignacion_director on solicitud_modalidad.solm_id = asignacion_director.solm_id\n" +
            "inner join director on asignacion_director.dir_id = director.dir_id\n" +
            "where solicitud_modalidad.mod_id = 9\n" +
            "AND solicitud_modalidad_estado.est_id = 6\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from cierre_modalidad)", nativeQuery = true)
    List<Practica_solicitudProjection> findPractica_solicitud();

    public interface Practica_cierreProjection extends Modalidades_solicitudProjection {
        String getPra_contrato_pdf();
        String getPas_nombre_empresa();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre,\n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, pratica.pra_contrato_pdf, empresa.pas_nombre_empresa, \n" +
            "concepto.con_concepto, concepto.con_fecha\n" +
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
            "AND solicitud_modalidad_estado.est_id IN (2, 3, 4, 5)", nativeQuery = true)
    List<Practica_cierreProjection> findPractica_cierre();

    //todo Semillero, Producción, Seminario, Portafolio
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, concepto.con_concepto, concepto.con_fecha, \n" +
            "asignacion_director.asig_fecha_inicial, asignacion_director.asig_fecha_final, director.dir_nombre, \n" +
            "director.dir_primer_apellido, director.dir_segundo_apellido, asignacion_director.dir_id, asignacion_director.asig_id\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "inner join asignacion_director on solicitud_modalidad.solm_id = asignacion_director.solm_id\n" +
            "inner join director on asignacion_director.dir_id = director.dir_id\n" +
            "where solicitud_modalidad.mod_id = :id\n" +
            "AND solicitud_modalidad_estado.est_id = 6\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from cierre_modalidad)", nativeQuery = true)
    List<Modalidades_solicitudProjection> findModalidadesOtras_solicitud(@Param("id") Long id);

    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, solicitud_modalidad_estado.sest_fecha, \n" +
            "estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, estudiante_programa.esp_email, \n" +
            "estudiante.estu_identificacion, estudiante.estu_telefono, concepto.con_concepto, concepto.con_fecha\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "where solicitud_modalidad.mod_id = :id\n" +
            "AND solicitud_modalidad_estado.est_id IN (2, 3, 4, 5)", nativeQuery = true)
    List<Modalidades_solicitudProjection> findModalidadesOtras_cierre(@Param("id") Long id);


    public interface EstudiantesEjecucionProjection extends Modalidades_solicitudProjection {
        String getMod_nombre();
    }
    @Query(value = "select solicitud_modalidad.solm_id, estudiante_programa.esp_codigo, estudiante.estu_nombre, \n" +
            "estudiante.estu_primer_apellido, estudiante.estu_segundo_apellido, modalidad.mod_nombre,\n" +
            "solicitud_modalidad_estado.sest_fecha, estado.est_nombre, estudiante.estu_id, solicitud_modalidad.solm_form_pdf, \n" +
            "estudiante_programa.esp_email, estudiante.estu_identificacion, estudiante.estu_telefono, \n" +
            "concepto.con_concepto, concepto.con_fecha, asignacion_director.asig_fecha_inicial, asignacion_director.asig_fecha_final,\n" +
            "director.dir_nombre, director.dir_primer_apellido, director.dir_segundo_apellido, asignacion_director.dir_id, asignacion_director.asig_id\n" +
            "from solicitud_modalidad\n" +
            "inner join estudiante_solicitud_modalidad on solicitud_modalidad.solm_id = estudiante_solicitud_modalidad.solm_id\n" +
            "inner join estudiante on estudiante_solicitud_modalidad.estu_id = estudiante.estu_id\n" +
            "inner join estudiante_programa on estudiante.estu_id = estudiante_programa.estu_id\n" +
            "inner join solicitud_modalidad_estado on solicitud_modalidad.solm_id = solicitud_modalidad_estado.solm_id\n" +
            "inner join estado on solicitud_modalidad_estado.est_id = estado.est_id\n" +
            "inner join concepto on solicitud_modalidad.solm_id = concepto.solm_id\n" +
            "inner join asignacion_director on solicitud_modalidad.solm_id = asignacion_director.solm_id\n" +
            "inner join director on asignacion_director.dir_id = director.dir_id\n" +
            "inner join modalidad on solicitud_modalidad.mod_id = modalidad.mod_id\n" +
            "where solicitud_modalidad_estado.est_id = 6\n" +
            "AND solicitud_modalidad.solm_id not in (\n" +
            "select solm_id from cierre_modalidad);", nativeQuery = true)
    List<EstudiantesEjecucionProjection> findEstudiantesEjecucion();
}
