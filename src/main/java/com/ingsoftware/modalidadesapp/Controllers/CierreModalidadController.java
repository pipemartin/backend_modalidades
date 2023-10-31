package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.ICierreModalidadService;
import com.ingsoftware.modalidadesapp.Models.AsignacionDirectorRequest;
import com.ingsoftware.modalidadesapp.Models.CierreModalidadModel;
import com.ingsoftware.modalidadesapp.Models.CierreModalidadRequest;
import com.ingsoftware.modalidadesapp.Repositories.ICierreModalidadRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cierre")
public class CierreModalidadController {

    @Autowired
    private ICierreModalidadService service;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @GetMapping()
    public List<CierreModalidadModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<CierreModalidadModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CierreModalidadModel save(@RequestBody CierreModalidadModel cierre) {return service.save(cierre);}

    //todo Listar
    @GetMapping("/proyecto_solicitud")
    public ResponseEntity<List<ICierreModalidadRepository.Proyecto_solicitudProjection>> obtenerCProyectoSolicitud() {
        List<ICierreModalidadRepository.Proyecto_solicitudProjection> proyectoData = service.findProyecto_solicitud();
        return new ResponseEntity<>(proyectoData, HttpStatus.OK);
    }

    @GetMapping("/proyecto_historial")
    public ResponseEntity<List<ICierreModalidadRepository.Proyecto_cierreProjection>> obtenerCProyectoCierre() {
        List<ICierreModalidadRepository.Proyecto_cierreProjection> proyectoDataCierre = service.findProyecto_cierre();
        return new ResponseEntity<>(proyectoDataCierre, HttpStatus.OK);
    }

    @GetMapping("/pasantia_solicitud")
    public ResponseEntity<List<ICierreModalidadRepository.Pasantia_solicitudProjection>> obtenerCPasantiaSolicitud() {
        List<ICierreModalidadRepository.Pasantia_solicitudProjection> pasantiaData = service.findPasantia_solicitud();
        return new ResponseEntity<>(pasantiaData, HttpStatus.OK);
    }

    @GetMapping("/pasantia_historial")
    public ResponseEntity<List<ICierreModalidadRepository.Pasantia_cierreProjection>> obtenerCPasantiaCierre() {
        List<ICierreModalidadRepository.Pasantia_cierreProjection> pasantiaDataCierre = service.findPasantia_cierre();
        return new ResponseEntity<>(pasantiaDataCierre, HttpStatus.OK);
    }

    @GetMapping("/postgrado_solicitud")
    public ResponseEntity<List<ICierreModalidadRepository.Postgrado_solicitudProjection>> obtenerCPostgradoSolicitud() {
        List<ICierreModalidadRepository.Postgrado_solicitudProjection> postgradoData = service.findPostgrado_solicitud();
        return new ResponseEntity<>(postgradoData, HttpStatus.OK);
    }

    @GetMapping("/postgrado_historial")
    public ResponseEntity<List<ICierreModalidadRepository.Postgrado_cierreProjection>> obtenerCPostgradoCierre() {
        List<ICierreModalidadRepository.Postgrado_cierreProjection> postgradoDataCierre = service.findPostgrado_cierre();
        return new ResponseEntity<>(postgradoDataCierre, HttpStatus.OK);
    }

    @GetMapping("/emprendimiento_solicitud")
    public ResponseEntity<List<ICierreModalidadRepository.Emprendimiento_solicitudProjection>> obtenerCEmprendimientoSolicitud() {
        List<ICierreModalidadRepository.Emprendimiento_solicitudProjection> emprendimientoData = service.findEmprendimiento_solicitud();
        return new ResponseEntity<>(emprendimientoData, HttpStatus.OK);
    }

    @GetMapping("/emprendimiento_historial")
    public ResponseEntity<List<ICierreModalidadRepository.Emprendimiento_cierreProjection>> obtenerCEmprendimientoCierre() {
        List<ICierreModalidadRepository.Emprendimiento_cierreProjection> emprendimientoDataCierre = service.findEmprendimiento_cierre();
        return new ResponseEntity<>(emprendimientoDataCierre, HttpStatus.OK);
    }

    @GetMapping("/practica_solicitud")
    public ResponseEntity<List<ICierreModalidadRepository.Practica_solicitudProjection>> obtenerCPracticaSolicitud() {
        List<ICierreModalidadRepository.Practica_solicitudProjection> practicaData = service.findPractica_solicitud();
        return new ResponseEntity<>(practicaData, HttpStatus.OK);
    }

    @GetMapping("/practica_historial")
    public ResponseEntity<List<ICierreModalidadRepository.Practica_cierreProjection>> obtenerCPracticaCierre() {
        List<ICierreModalidadRepository.Practica_cierreProjection> practicaDataCierre = service.findPractica_cierre();
        return new ResponseEntity<>(practicaDataCierre, HttpStatus.OK);
    }

    @GetMapping("/modalidadesOtras_solicitud/{id}")
    public ResponseEntity<List<ICierreModalidadRepository.Modalidades_solicitudProjection>> obtenerCModalidadesotrasSolicitud(@PathVariable Long id) {
        List<ICierreModalidadRepository.Modalidades_solicitudProjection> modalidadesOtrasData = service.findModalidadesOtras_solicitud(id);
        return new ResponseEntity<>(modalidadesOtrasData, HttpStatus.OK);
    }

    @GetMapping("/modalidadesOtras_historial/{id}")
    public ResponseEntity<List<ICierreModalidadRepository.Modalidades_solicitudProjection>> obtenerCModalidadesotrasCierre(@PathVariable Long id) {
        List<ICierreModalidadRepository.Modalidades_solicitudProjection> modalidadesOtrasDataCierre = service.findModalidadesOtras_cierre(id);
        return new ResponseEntity<>(modalidadesOtrasDataCierre, HttpStatus.OK);
    }

    //todo Guardar
    @PostMapping("/crear_cierre_modalidad")
    public ResponseEntity<String> crear_cierre(@RequestBody CierreModalidadRequest cierreModalidadRequest){

        String cie_concepto = cierreModalidadRequest.getCie_concepto();
        Long solm_id = cierreModalidadRequest.getSolm_id();
        Long est_id = cierreModalidadRequest.getEst_id();

        service.saveCierreModalidad(cie_concepto, solm_id, est_id);

        return ResponseEntity.ok("Cierre de modalidad creada");
    }

    //todo Actualizar
    @PutMapping("/{asigId}")
    public ResponseEntity<?> updateAsignarDirector(
            @PathVariable Long asigId,
            @RequestBody AsignacionDirectorRequest request
    ) {
        try {
            service.updateAsignarDirector(
                    asigId,
                    request.getAsig_fecha_final(),
                    request.getAsig_fecha_inicial(),
                    request.getDir_id()
            );
            return ResponseEntity.ok("Asignación actualizada con éxito");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La asignación no fue encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la asignación");
        }
    }

    @PutMapping("/updateEstadoDirector/{asigId}")
    public ResponseEntity<?> updateEstadoDirector(
            @PathVariable Long asigId
    ) {
        try {
            service.updateEstadoDirector( asigId );

            return ResponseEntity.ok("Estado del director actualizado con éxito");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La asignación no fue encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la asignación");
        }
    }


    @GetMapping("/estudiantes_ejecucion")
    public ResponseEntity<List<ICierreModalidadRepository.EstudiantesEjecucionProjection>> obtenerEstudianteEjecucion() {
        List<ICierreModalidadRepository.EstudiantesEjecucionProjection> estudiantesData = service.findPEstudiantesEjecucion();
        return new ResponseEntity<>(estudiantesData, HttpStatus.OK);
    }
}
