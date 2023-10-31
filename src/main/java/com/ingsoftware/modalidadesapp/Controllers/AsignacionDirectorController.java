package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IAsignacionDirectorService;
import com.ingsoftware.modalidadesapp.Models.AsignacionDirectorModel;
import com.ingsoftware.modalidadesapp.Models.AsignacionDirectorRequest;
import com.ingsoftware.modalidadesapp.Repositories.IAsignacionDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/asignacion_director")
public class AsignacionDirectorController {

    @Autowired
    private IAsignacionDirectorService service;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @GetMapping()
    public List<AsignacionDirectorModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<AsignacionDirectorModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AsignacionDirectorModel save(@RequestBody AsignacionDirectorModel asignacionDirector) {return service.save(asignacionDirector);}

    //todo Listar

    @GetMapping("/proyecto_solicitud")
    public ResponseEntity<List<IAsignacionDirectorRepository.Proyecto_solicitudProjection>> obtenerAProyectoSolicitud() {
        List<IAsignacionDirectorRepository.Proyecto_solicitudProjection> proyectoData = service.findProyecto_solicitud();
        return new ResponseEntity<>(proyectoData, HttpStatus.OK);
    }

    @GetMapping("/pasantia_solicitud")
    public ResponseEntity<List<IAsignacionDirectorRepository.Pasantia_solicitudProjection>> obtenerAPasantiaSolicitud() {
        List<IAsignacionDirectorRepository.Pasantia_solicitudProjection> pasantiaData = service.findPasantia_solicitud();
        return new ResponseEntity<>(pasantiaData, HttpStatus.OK);
    }

    @GetMapping("/postgrado_solicitud")
    public ResponseEntity<List<IAsignacionDirectorRepository.Postgrado_solicitudProjection>> obtenerAPostgradoSolicitud() {
        List<IAsignacionDirectorRepository.Postgrado_solicitudProjection> postgradoData = service.findPostgrado_solicitud();
        return new ResponseEntity<>(postgradoData, HttpStatus.OK);
    }

    @GetMapping("/emprendimiento_solicitud")
    public ResponseEntity<List<IAsignacionDirectorRepository.Emprendimiento_solicitudProjection>> obtenerAEmprendimientoSolicitud() {
        List<IAsignacionDirectorRepository.Emprendimiento_solicitudProjection> emprendimientoData = service.findEmprendimiento_solicitud();
        return new ResponseEntity<>(emprendimientoData, HttpStatus.OK);
    }

    @GetMapping("/practica_solicitud")
    public ResponseEntity<List<IAsignacionDirectorRepository.Practica_solicitudProjection>> obtenerAPracticaSolicitud() {
        List<IAsignacionDirectorRepository.Practica_solicitudProjection> practicaData = service.findPractica_solicitud();
        return new ResponseEntity<>(practicaData, HttpStatus.OK);
    }

    @GetMapping("/modalidadesOtras_solicitud/{id}")
    public ResponseEntity<List<IAsignacionDirectorRepository.Modalidades_solicitudProjection>> obtenerAModalidadesotrasSolicitud(@PathVariable Long id) {
        List<IAsignacionDirectorRepository.Modalidades_solicitudProjection> modalidadesOtrasData = service.findModalidadesOtras_solicitud(id);
        return new ResponseEntity<>(modalidadesOtrasData, HttpStatus.OK);
    }

    //todo Guardar
    @PostMapping("/crear_asignacion_director")
    public ResponseEntity<String> crear_asignacion(@RequestBody AsignacionDirectorRequest asignacionDirectorRequest){

        Long solm_id = asignacionDirectorRequest.getSolm_id();
        Date asig_fecha_final = asignacionDirectorRequest.getAsig_fecha_final();
        Date asig_fecha_inicial = asignacionDirectorRequest.getAsig_fecha_inicial();
        Long dir_id = asignacionDirectorRequest.getDir_id();

        service.saveAsignarDirector(solm_id, asig_fecha_final, asig_fecha_inicial, dir_id);

        return ResponseEntity.ok("Asignación de director creada");
    }
}
