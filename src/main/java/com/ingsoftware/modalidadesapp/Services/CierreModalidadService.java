package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.ICierreModalidadService;
import com.ingsoftware.modalidadesapp.Models.*;
import com.ingsoftware.modalidadesapp.Repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CierreModalidadService implements ICierreModalidadService {

    @Autowired
    private ICierreModalidadRepository cierreModalidadRepository;

    @Autowired
    private IDirectorRepository directorRepository;

    @Autowired
    private ISolicitudModalidadRepository solicitudModalidadRepository;

    @Autowired
    private IAsignacionDirectorRepository asignacionDirectorRepository;

    @Autowired
    private ISolicitudEstadoRepository solicitudEstadoRepository;

    @Autowired
    private IEstadoRepository estadoRepository;



    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @Override
    public List<CierreModalidadModel> all(){return cierreModalidadRepository.findAll();}

    @Override
    public Optional<CierreModalidadModel> findById(Long id) {return cierreModalidadRepository.findById(id);}

    @Override
    public CierreModalidadModel save(CierreModalidadModel cierre) {return cierreModalidadRepository.save(cierre);}

    //todo Listar

    @Override
    public List<ICierreModalidadRepository.Proyecto_solicitudProjection>findProyecto_solicitud(){
        return cierreModalidadRepository.findProyecto_solicitud();
    }

    @Override
    public List<ICierreModalidadRepository.Proyecto_cierreProjection>findProyecto_cierre(){
        return cierreModalidadRepository.findProyecto_cierre();
    }

    @Override
    public List<ICierreModalidadRepository.Pasantia_solicitudProjection>findPasantia_solicitud(){
        return cierreModalidadRepository.findPasantia_solicitud();
    }

    @Override
    public List<ICierreModalidadRepository.Pasantia_cierreProjection>findPasantia_cierre(){
        return cierreModalidadRepository.findPasantia_cierre();
    }

    @Override
    public List<ICierreModalidadRepository.Postgrado_solicitudProjection>findPostgrado_solicitud(){
        return cierreModalidadRepository.findPostgrado_solicitud();
    }

    @Override
    public List<ICierreModalidadRepository.Postgrado_cierreProjection>findPostgrado_cierre(){
        return cierreModalidadRepository.findPostgrado_cierre();
    }

    @Override
    public List<ICierreModalidadRepository.Emprendimiento_solicitudProjection>findEmprendimiento_solicitud(){
        return cierreModalidadRepository.findEmprendimiento_solicitud();
    }

    @Override
    public List<ICierreModalidadRepository.Emprendimiento_cierreProjection>findEmprendimiento_cierre(){
        return cierreModalidadRepository.findEmprendimiento_cierre();
    }

    @Override
    public List<ICierreModalidadRepository.Practica_solicitudProjection>findPractica_solicitud(){
        return cierreModalidadRepository.findPractica_solicitud();
    }

    @Override
    public List<ICierreModalidadRepository.Practica_cierreProjection>findPractica_cierre(){
        return cierreModalidadRepository.findPractica_cierre();
    }

    @Override
    public List<ICierreModalidadRepository.Modalidades_solicitudProjection>findModalidadesOtras_solicitud(Long id){
        return cierreModalidadRepository.findModalidadesOtras_solicitud(id);
    }

    @Override
    public List<ICierreModalidadRepository.Modalidades_solicitudProjection>findModalidadesOtras_cierre(Long id){
        return cierreModalidadRepository.findModalidadesOtras_cierre(id);
    }

    //todo Guardar
    @Override
    public void saveCierreModalidad(String cie_concepto, Long solm_id, Long est_id){

        //Guarda en: CierreModalidadModel
        Date fechaCierre = new Date();
        Optional<SolicitudModalidadModel> idSolicitud = solicitudModalidadRepository.findById(solm_id);

        CierreModalidadModel nuevoCierre = new CierreModalidadModel();
        nuevoCierre.setCie_concepto(cie_concepto);
        nuevoCierre.setCie_fecha(fechaCierre);
        nuevoCierre.setSolicitudModalidad(idSolicitud.get());

        cierreModalidadRepository.save(nuevoCierre);

        //Guardar en tabla: solicitudEstadoModel
        Optional<EstadoModel> idEstado = estadoRepository.findById(est_id);

        SolicitudEstadoModel nuevaSolicitudModalidaEstado = new SolicitudEstadoModel();

        nuevaSolicitudModalidaEstado.setSest_fecha(fechaCierre);
        nuevaSolicitudModalidaEstado.setEst_id(idEstado.get());
        nuevaSolicitudModalidaEstado.setSolm_id(idSolicitud.get());

        solicitudEstadoRepository.save(nuevaSolicitudModalidaEstado);
    }

    //todo Actualizar
    @Override
    public void updateAsignarDirector(Long asig_id, Date asig_fecha_final, Date asig_fecha_inicial, Long dir_id){

        // Verifica si la asignación existe
        Optional<AsignacionDirectorModel> asignacionExistente = asignacionDirectorRepository.findById(asig_id);


        if (asignacionExistente.isPresent()) {
            AsignacionDirectorModel asignacionDirector = asignacionExistente.get();

            // Actualiza los campos necesarios
            asignacionDirector.setAsig_fecha_final(asig_fecha_final);
            asignacionDirector.setAsig_fecha_inicial(asig_fecha_inicial);

            Optional<DirectorModel> idDirector = directorRepository.findById(dir_id);
            asignacionDirector.setDir_id(idDirector.get());
            // Puedes actualizar otros campos aquí si es necesario

            // Actualiza el registro en la base de datos
            asignacionDirectorRepository.save(asignacionDirector);
        } else {
            // Manejar el caso en el que la asignación no existe
            throw new EntityNotFoundException("La asignación con ID " + asig_id + " no fue encontrada.");
        }
    }

    @Override
    public void updateEstadoDirector(Long asig_id){

        // Verifica si la asignación existe
        Optional<AsignacionDirectorModel> asignacionExistente = asignacionDirectorRepository.findById(asig_id);


        if (asignacionExistente.isPresent()) {
            String asig_estado = "0";
            AsignacionDirectorModel asignacionDirector = asignacionExistente.get();

            // Actualiza los campos necesarios
            asignacionDirector.setAsig_estado(asig_estado);

            // Actualiza el registro en la base de datos
            asignacionDirectorRepository.save(asignacionDirector);
        } else {
            // Manejar el caso en el que la asignación no existe
            throw new EntityNotFoundException("La asignación con ID " + asig_id + " no fue encontrada.");
        }
    }

    @Override
    public List<ICierreModalidadRepository.EstudiantesEjecucionProjection> findPEstudiantesEjecucion() {
        return cierreModalidadRepository.findEstudiantesEjecucion();
    }
}
