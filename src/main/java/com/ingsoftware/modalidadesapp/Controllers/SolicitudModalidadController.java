package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.ISolicitudModalidadService;
import com.ingsoftware.modalidadesapp.Models.*;
import com.ingsoftware.modalidadesapp.Repositories.ISedeFacultadRepository;
import com.ingsoftware.modalidadesapp.Repositories.ISolicitudModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/solicitud_modalidad")
public class SolicitudModalidadController {
    @Autowired
    private ISolicitudModalidadService service;

    @GetMapping()
    public List<SolicitudModalidadModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<SolicitudModalidadModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public SolicitudModalidadModel save(@RequestBody SolicitudModalidadModel solicitudModalidad) {return service.save(solicitudModalidad);}

    //TODO Para crear solicitud de Modalidad PROYECTO DE GRADO
    @PostMapping("/crear_solicitud_proyecto")
    public ResponseEntity<String> crearSolicitudProyecto(@RequestBody SolicitudProyectoRequest solicitudProyectoRequest){
        String pdfFormulario = solicitudProyectoRequest.getPdfFormulario();
        Long tipoModalidad = solicitudProyectoRequest.getTipoModalidad();
        String titulo = solicitudProyectoRequest.getTitulo();

        service.saveSolicitudProyecto(pdfFormulario, tipoModalidad, titulo);

        return ResponseEntity.ok("Solicitud y proyecto creados exitosamente");
    }

    //TODO Para crear solicitud de Modalidad PLAN COMPLEMENTARIO EN PROGRAMA DE POSGRADO
    @PostMapping("/crear_solicitud_posgrado")
    public ResponseEntity<String> crearSolicitudPosgrado(@RequestBody SolicitudPosgradoRequest solicitudPosgradoRequest){
        String pdfFormulario = solicitudPosgradoRequest.getPdfFormulario();
        Long tipoModalidad = solicitudPosgradoRequest.getTipoModalidad();
        String nombrePosgrado = solicitudPosgradoRequest.getNombrePosgrado();
        String pdfPosgrado = solicitudPosgradoRequest.getPdfPosgrado();

        service.saveSolicitudPosgrado(pdfFormulario, tipoModalidad, nombrePosgrado, pdfPosgrado);

        return ResponseEntity.ok("Solicitud y posgrado creados exitosamente");
    }

    //TODO Para crear solicitud de Modalidad PRÁCTICA PROFESIONAL
    @PostMapping("/crear_solicitud_practica")
    public ResponseEntity<String> crearSolicitudPractica(@RequestBody SolicitudPracticaRequest solicitudPracticaRequest){
        String pdfFormulario = solicitudPracticaRequest.getPdfFormulario();
        Long tipoModalidad = solicitudPracticaRequest.getTipoModalidad();
        String pdfPractica = solicitudPracticaRequest.getPdfPractica();
        String pas_nombre_empresa = solicitudPracticaRequest.getPas_nombre_empresa();
        String pas_direccion_empresa = solicitudPracticaRequest.getPas_direccion_empresa();
        String pas_telefono_empresa = solicitudPracticaRequest.getPas_telefono_empresa();
        String pas_actividad_empresa = solicitudPracticaRequest.getPas_actividad_empresa();
        String pas_nombre_responsable = solicitudPracticaRequest.getPas_nombre_responsable();
        String pas_primer_apellido_responsable = solicitudPracticaRequest.getPas_primer_apellido_responsable();
        String pas_segundo_apellido_responsable = solicitudPracticaRequest.getPas_segundo_apellido_responsable();
        String pas_cargo_responsable = solicitudPracticaRequest.getPas_cargo_responsable();
        String pas_telefono_responsable = solicitudPracticaRequest.getPas_telefono_responsable();
        String pas_email_responsable = solicitudPracticaRequest.getPas_email_responsable();
        Long tipe_id = solicitudPracticaRequest.getTipe_id();

        service.saveSolicitudPractica(pdfFormulario, tipoModalidad, pdfPractica, pas_nombre_empresa,
                pas_direccion_empresa, pas_telefono_empresa, pas_actividad_empresa,
                pas_nombre_responsable, pas_primer_apellido_responsable,
                pas_segundo_apellido_responsable, pas_cargo_responsable,
                pas_telefono_responsable, pas_email_responsable, tipe_id);

        return ResponseEntity.ok("Solicitud y practica creados exitosamente");
    }

    //TODO Para crear solicitud de Modalidad PASANTÍA SUPERVISADA
    @PostMapping("/crear_solicitud_pasantia")
    public ResponseEntity<String> crearSolicitudPasantia(@RequestBody SolicitudPasantiaRequest solicitudPasantiaRequest){
        String pdfFormulario = solicitudPasantiaRequest.getPdfFormulario();
        Long tipoModalidad = solicitudPasantiaRequest.getTipoModalidad();

        String pas_nombre_empresa = solicitudPasantiaRequest.getPas_nombre_empresa();
        String pas_direccion_empresa = solicitudPasantiaRequest.getPas_direccion_empresa();
        String pas_telefono_empresa = solicitudPasantiaRequest.getPas_telefono_empresa();
        String pas_actividad_empresa = solicitudPasantiaRequest.getPas_actividad_empresa();
        String pas_nombre_responsable = solicitudPasantiaRequest.getPas_nombre_responsable();
        String pas_primer_apellido_responsable = solicitudPasantiaRequest.getPas_primer_apellido_responsable();
        String pas_segundo_apellido_responsable = solicitudPasantiaRequest.getPas_segundo_apellido_responsable();
        String pas_cargo_responsable = solicitudPasantiaRequest.getPas_cargo_responsable();
        String pas_telefono_responsable = solicitudPasantiaRequest.getPas_telefono_responsable();
        String pas_email_responsable = solicitudPasantiaRequest.getPas_email_responsable();
        Long tipe_id = solicitudPasantiaRequest.getTipe_id();

        service.saveSolicitudPasantia(pdfFormulario, tipoModalidad, pas_nombre_empresa,
                pas_direccion_empresa, pas_telefono_empresa, pas_actividad_empresa,
                pas_nombre_responsable, pas_primer_apellido_responsable,
                pas_segundo_apellido_responsable, pas_cargo_responsable,
                pas_telefono_responsable, pas_email_responsable, tipe_id);

        return ResponseEntity.ok("Solicitud y pasantía creados exitosamente");
    }

    //TODO Para crear solicitud de Modalidad EMPRENDIMIENTO Y FORTALECIMIENTO DE EMPRESA
    @PostMapping("/crear_solicitud_emprendimiento")
    public ResponseEntity<String> crearSolicitudEmprendimiento(@RequestBody SolicitudEmprendimientoRequest solicitudEmprendimientoRequest){
        String pdfFormulario = solicitudEmprendimientoRequest.getPdfFormulario();
        Long tipoModalidad = solicitudEmprendimientoRequest.getTipoModalidad();
        Long categoria = solicitudEmprendimientoRequest.getCategoria();
        String pdfEmprendimiento = solicitudEmprendimientoRequest.getPdfEmprendimiento();

        service.saveSolicitudEmprendimiento(pdfFormulario, tipoModalidad, categoria, pdfEmprendimiento);

        return ResponseEntity.ok("Solicitud y emprendimiento creados exitosamente");
    }

    //TODO Para crear solicitud de Modalidades (SEMILLERO DE INVESTIGACIÓN,
    // PRODUCCIÓN ACADÉMICA DE ALTO NIVEL, PORTAFOLIO PROFESIONAL y SEMINARIO)
    @PostMapping("/crear_solicitud_otras")
    public ResponseEntity<String> crearSolicitudOtras(@RequestBody SolicitudOtrasRequest solicitudOtrasRequest){
        String pdfFormulario = solicitudOtrasRequest.getPdfFormulario();
        Long tipoModalidad = solicitudOtrasRequest.getTipoModalidad();

        service.saveSolicitudOtras(pdfFormulario, tipoModalidad);

        return ResponseEntity.ok("Solicitud y otras creados exitosamente");
    }


}
