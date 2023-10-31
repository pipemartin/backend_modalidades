package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.SedeFacultadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISedeFacultadRepository extends JpaRepository<SedeFacultadModel, Long> {



    public interface SedeFacultadProjection {
        Long getFacId();
        String getFacNombre();
    }


    @Query(value = "SELECT sf.fac_id AS facId, f.fac_nombre AS facNombre FROM facultad f\n" +
            "INNER JOIN sede_facultad sf ON sf.fac_id = f.fac_id\n" +
            "WHERE sf.sed_id = :id", nativeQuery = true)
    List<SedeFacultadProjection> findFacultadDataByIdSede(@Param("id") Long id);



}
