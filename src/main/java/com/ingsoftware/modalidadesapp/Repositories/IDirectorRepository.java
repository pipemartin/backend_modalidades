package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.DirectorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IDirectorRepository extends JpaRepository<DirectorModel, Long> {

    public interface DirectorModalidad_Projection {
        Long getSolm_id();
        Long getDir_id();
        String getDir_nombre();
        String getDir_primer_apellido();
        String getDir_segundo_apellido();
        String getMod_nombre();
        Date getAsig_fecha_inicial();
        Date getAsig_fecha_final();
        String getAsig_estado();
    }
    @Query(value = "select director.dir_nombre, director.dir_primer_apellido, director.dir_segundo_apellido, director.dir_id,\n" +
            "modalidad.mod_nombre, asignacion_director.asig_fecha_inicial, asignacion_director.asig_fecha_final, \n" +
            "asignacion_director.solm_id, asignacion_director.asig_estado\n" +
            "from solicitud_modalidad\n" +
            "inner join asignacion_director on solicitud_modalidad.solm_id = asignacion_director.solm_id\n" +
            "inner join director on asignacion_director.dir_id = director.dir_id\n" +
            "inner join modalidad on solicitud_modalidad.mod_id = modalidad.mod_id\n" +
            "where director.dir_estado = '1'", nativeQuery = true)
    List<DirectorModalidad_Projection> findDirectorModalidad();

}
