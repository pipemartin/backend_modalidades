package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IAsignacionDirectorService;
import com.ingsoftware.modalidadesapp.Models.*;
import com.ingsoftware.modalidadesapp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AsignacionDirectorService implements IAsignacionDirectorService {

    @Autowired
    private IAsignacionDirectorRepository asignacionDirectorRepository;

    @Autowired
    private IDirectorRepository directorRepository;

    @Autowired
    private ISolicitudModalidadRepository solicitudModalidadRepository;

    @Autowired
    private ISolicitudEstadoRepository solicitudEstadoRepository;

    @Autowired
    private IEstadoRepository estadoRepository;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @Override
    public List<AsignacionDirectorModel> all(){return asignacionDirectorRepository.findAll();}

    @Override
    public Optional<AsignacionDirectorModel> findById(Long id) {return asignacionDirectorRepository.findById(id);}

    @Override
    public AsignacionDirectorModel save(AsignacionDirectorModel asignacionDirector) {return asignacionDirectorRepository.save(asignacionDirector);}

    //todo Listar

    @Override
    public List<IAsignacionDirectorRepository.Proyecto_solicitudProjection>findProyecto_solicitud(){
        return asignacionDirectorRepository.findProyecto_solicitud();
    }

    @Override
    public List<IAsignacionDirectorRepository.Pasantia_solicitudProjection>findPasantia_solicitud(){
        return asignacionDirectorRepository.findPasantia_solicitud();
    }

    @Override
    public List<IAsignacionDirectorRepository.Postgrado_solicitudProjection>findPostgrado_solicitud(){
        return asignacionDirectorRepository.findPostgrado_solicitud();
    }

    @Override
    public List<IAsignacionDirectorRepository.Emprendimiento_solicitudProjection>findEmprendimiento_solicitud(){
        return asignacionDirectorRepository.findEmprendimiento_solicitud();
    }

    @Override
    public List<IAsignacionDirectorRepository.Practica_solicitudProjection>findPractica_solicitud(){
        return asignacionDirectorRepository.findPractica_solicitud();
    }

    @Override
    public List<IAsignacionDirectorRepository.Modalidades_solicitudProjection>findModalidadesOtras_solicitud(Long id){
        return asignacionDirectorRepository.findModalidadesOtras_solicitud(id);
    }

    //todo Guardar
    @Override
    public void saveAsignarDirector(Long solm_id, Date asig_fecha_final, Date asig_fecha_inicial, Long dir_id){

        //Guarda en: AsignacionDirectorModel
        String asig_estado = "1";

        Optional<DirectorModel> idDirector = directorRepository.findById(dir_id);
        Optional<SolicitudModalidadModel> idSolicitud = solicitudModalidadRepository.findById(solm_id);

        AsignacionDirectorModel nuevaAsignacion = new AsignacionDirectorModel();
        nuevaAsignacion.setAsig_estado(asig_estado);
        nuevaAsignacion.setAsig_fecha_final(asig_fecha_final);
        nuevaAsignacion.setAsig_fecha_inicial(asig_fecha_inicial);
        nuevaAsignacion.setDir_id(idDirector.get());
        nuevaAsignacion.setSolicitudModalidad(idSolicitud.get());

        asignacionDirectorRepository.save(nuevaAsignacion);

        // Guarda en: SolicitudEstadoModel
        Date fechaSolicitud = new Date();
        Long estado = 6L;

        Optional<EstadoModel> idEstado = estadoRepository.findById(estado);

        SolicitudEstadoModel nuevaSolicitudEstado = new SolicitudEstadoModel();
        nuevaSolicitudEstado.setSest_fecha(fechaSolicitud);
        nuevaSolicitudEstado.setEst_id(idEstado.get());
        nuevaSolicitudEstado.setSolm_id(idSolicitud.get());

        solicitudEstadoRepository.save(nuevaSolicitudEstado);
    }
}
