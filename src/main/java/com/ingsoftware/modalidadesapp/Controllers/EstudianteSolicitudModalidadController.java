package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IEstudianteSolicitudModalidadService;
import com.ingsoftware.modalidadesapp.Models.EstudianteSolicitudModalidadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/estudiante_solicitud_modalidad")
public class EstudianteSolicitudModalidadController {
    @Autowired
    private IEstudianteSolicitudModalidadService service;

    @GetMapping()
    public List<EstudianteSolicitudModalidadModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<EstudianteSolicitudModalidadModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EstudianteSolicitudModalidadModel save(@RequestBody EstudianteSolicitudModalidadModel estudianteSolicitudModalidad) {return service.save(estudianteSolicitudModalidad);}
}
