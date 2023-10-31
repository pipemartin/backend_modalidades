package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IConceptoService;
import com.ingsoftware.modalidadesapp.Models.ConceptoModel;
import com.ingsoftware.modalidadesapp.Models.ConceptoRequest;
import com.ingsoftware.modalidadesapp.Repositories.IConceptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/concepto")
public class ConceptoController {

    @Autowired
    private IConceptoService service;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @GetMapping()
    public List<ConceptoModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<ConceptoModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ConceptoModel save(@RequestBody ConceptoModel concepto) {return service.save(concepto);}

    //todo Listar

    @GetMapping("/proyecto_solicitud")
    public ResponseEntity<List<IConceptoRepository.proyecto_solicitudProjection>> obtenerPryectoSolicitud() {
        List<IConceptoRepository.proyecto_solicitudProjection> proyectoData = service.findProyecto_solicitud();
        return new ResponseEntity<>(proyectoData, HttpStatus.OK);
    }

    @GetMapping("/pasantia_solicitud")
    public ResponseEntity<List<IConceptoRepository.pasantia_solicitudProjection>> obtenerPasantiaSolicitud() {
        List<IConceptoRepository.pasantia_solicitudProjection> pasantiaData = service.findPasantia_solicitud();
        return new ResponseEntity<>(pasantiaData, HttpStatus.OK);
    }

    @GetMapping("/postgrado_solicitud")
    public ResponseEntity<List<IConceptoRepository.postgrado_solicitudProjection>> obtenerPostgradoSolicitud() {
        List<IConceptoRepository.postgrado_solicitudProjection> postgradoData = service.findPostgrado_solicitud();
        return new ResponseEntity<>(postgradoData, HttpStatus.OK);
    }

    @GetMapping("/emprendimiento_solicitud")
    public ResponseEntity<List<IConceptoRepository.emprendimiento_solicitudProjection>> obtenerEmprendimientoSolicitud() {
        List<IConceptoRepository.emprendimiento_solicitudProjection> emprendimientoData = service.findEmprendimiento_solicitud();
        return new ResponseEntity<>(emprendimientoData, HttpStatus.OK);
    }

    @GetMapping("/practica_solicitud")
    public ResponseEntity<List<IConceptoRepository.practica_solicitudProjection>> obtenerPracticaSolicitud() {
        List<IConceptoRepository.practica_solicitudProjection> practicaData = service.findPractica_solicitud();
        return new ResponseEntity<>(practicaData, HttpStatus.OK);
    }

    @GetMapping("/modalidadesOtras_solicitud/{id}")
    public ResponseEntity<List<IConceptoRepository.modalidades_solicitudProjection>> obtenerModalidadesOtrasSolicitud(@PathVariable Long id) {
        List<IConceptoRepository.modalidades_solicitudProjection> modalidadesOtrasData = service.findModalidadesOtras_solicitud(id);
        return new ResponseEntity<>(modalidadesOtrasData, HttpStatus.OK);
    }

    //todo Guardar
    @PostMapping("/crear_concepto")
    public ResponseEntity<String>crearConcepto(@RequestBody ConceptoRequest conceptoRequest){

        String con_concepto = conceptoRequest.getCon_concepto();
        Long solm_id = conceptoRequest.getSolm_id();
        Long est_id = conceptoRequest.getEst_id();

        service.saveConceptoEstado(con_concepto, solm_id, est_id );

        return ResponseEntity.ok("Concepto creado exitosamente");
    }

}
