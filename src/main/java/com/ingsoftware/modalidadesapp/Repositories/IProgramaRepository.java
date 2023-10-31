package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.ProgramaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProgramaRepository extends JpaRepository<ProgramaModel, Long> {
    public interface FacultadProgramaProjection {
        Long getProId();
        String getProNombre();
    }

    @Query(value = "SELECT pr.pro_id AS proId, pr.pro_nombre AS proNombre FROM programa pr\n" +
            "INNER JOIN facultad f ON f.fac_id = pr.fac_id \n" +
            "WHERE f.fac_id = :id", nativeQuery = true)
    List<FacultadProgramaProjection> findProgramaDataByIdFacultad(@Param("id") Long id);
}
