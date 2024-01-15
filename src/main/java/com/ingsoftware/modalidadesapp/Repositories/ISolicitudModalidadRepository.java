package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.SolicitudModalidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

public interface ISolicitudModalidadRepository extends JpaRepository<SolicitudModalidadModel, Long> {

    @Query(value = "SELECT solm_id FROM solicitud_modalidad ORDER BY solm_id DESC LIMIT 1", nativeQuery = true)
    Long findLastInsertedId();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM estudiante_programa WHERE estu_id = :estuId", nativeQuery = true)
    void deleteEstudianteProg(@Param("estuId") String estu_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM estudiante WHERE estu_id = :estuId", nativeQuery = true)
    void deleteEstudiante(@Param("estuId") String estu_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM estudiante_solicitud_modalidad WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteEstudianteSolicitud(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM asignacion_director WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteAsignacionDirector(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM solicitud_modalidad_estado WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteEstadoSolicitud(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM proyecto_grado WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteProyectoGrado(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM concepto WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteConcepto(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cierre_modalidad WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteCierreModalidad(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM posgrado WHERE solm_id = :solicitudId", nativeQuery = true)
    void deletePosgrado(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pratica WHERE solm_id = :solicitudId", nativeQuery = true)
    void deletePractica(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empresa WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteEmpresa(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM emprendimiento WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteEmprendimiento(@Param("solicitudId") String solicitud_Id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM solicitud_modalidad WHERE solm_id = :solicitudId", nativeQuery = true)
    void deleteSolicitud(@Param("solicitudId") String solicitud_Id);

}