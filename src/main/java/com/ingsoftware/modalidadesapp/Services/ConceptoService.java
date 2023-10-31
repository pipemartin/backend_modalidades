package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IConceptoService;
import com.ingsoftware.modalidadesapp.Models.ConceptoModel;
import com.ingsoftware.modalidadesapp.Models.EstadoModel;
import com.ingsoftware.modalidadesapp.Models.SolicitudEstadoModel;
import com.ingsoftware.modalidadesapp.Models.SolicitudModalidadModel;
import com.ingsoftware.modalidadesapp.Repositories.IConceptoRepository;
import com.ingsoftware.modalidadesapp.Repositories.IEstadoRepository;
import com.ingsoftware.modalidadesapp.Repositories.ISolicitudEstadoRepository;
import com.ingsoftware.modalidadesapp.Repositories.ISolicitudModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConceptoService implements IConceptoService {

    @Autowired
    private IConceptoRepository conceptoRepository;

    @Autowired
    private ISolicitudModalidadRepository solicitudModalidadRepository;

    @Autowired
    private IEstadoRepository estadoRepository;

    @Autowired
    private ISolicitudEstadoRepository solicitudEstadoRepository;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @Override
    public List<ConceptoModel> all(){return conceptoRepository.findAll();}

    @Override
    public Optional<ConceptoModel> findById(Long id) {return conceptoRepository.findById(id);}

    @Override
    public ConceptoModel save(ConceptoModel concepto) {return conceptoRepository.save(concepto);}

    //todo Listar

    @Override
    public List<IConceptoRepository.proyecto_solicitudProjection>findProyecto_solicitud(){
        return conceptoRepository.findProyecto_solicitud();
    }

    @Override
    public List<IConceptoRepository.pasantia_solicitudProjection>findPasantia_solicitud(){
        return conceptoRepository.findPasantia_solicitud();
    }

    @Override
    public List<IConceptoRepository.postgrado_solicitudProjection>findPostgrado_solicitud(){
        return conceptoRepository.findPostgrado_solicitud();
    }

    @Override
    public List<IConceptoRepository.emprendimiento_solicitudProjection>findEmprendimiento_solicitud(){
        return conceptoRepository.findEmprendimiento_solicitud();
    }

    @Override
    public List<IConceptoRepository.modalidades_solicitudProjection>findModalidadesOtras_solicitud(Long id){
        return conceptoRepository.findModalidadesOtras_solicitud(id);
    }

    @Override
    public List<IConceptoRepository.practica_solicitudProjection>findPractica_solicitud(){
        return conceptoRepository.findPractica_solicitud();
    }

    //todo Guardar

    @Override
    public void saveConceptoEstado(String con_concepto, Long solm_id, Long est_id){
        // Guardar en tabla: ConceptoModel
        ConceptoModel nuevoConcepto = new ConceptoModel();
        Date fechaConcepto = new Date();
        Optional<SolicitudModalidadModel> solicitud = solicitudModalidadRepository.findById(solm_id);

        nuevoConcepto.setCon_concepto(con_concepto);
        nuevoConcepto.setCon_fecha(fechaConcepto);
        nuevoConcepto.setSolicitudModalidad(solicitud.get());

        conceptoRepository.save(nuevoConcepto);

        //Guardar en tabla: solicitudEstadoModel
        Optional<EstadoModel> idEstado = estadoRepository.findById(est_id);

        SolicitudEstadoModel nuevaSolicitudModalidaEstado = new SolicitudEstadoModel();

        nuevaSolicitudModalidaEstado.setSest_fecha(fechaConcepto);
        nuevaSolicitudModalidaEstado.setEst_id(idEstado.get());
        nuevaSolicitudModalidaEstado.setSolm_id(solicitud.get());

        solicitudEstadoRepository.save(nuevaSolicitudModalidaEstado);

    }
}
