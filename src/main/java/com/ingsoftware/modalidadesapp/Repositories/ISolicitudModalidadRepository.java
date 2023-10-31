package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.SolicitudModalidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ISolicitudModalidadRepository extends JpaRepository<SolicitudModalidadModel, Long> {
    @Query(value = "SELECT solm_id FROM solicitud_modalidad ORDER BY solm_id DESC LIMIT 1", nativeQuery = true)
    Long findLastInsertedId();

}