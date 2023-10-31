package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.ISolicitudEstadoService;
import com.ingsoftware.modalidadesapp.Models.SolicitudEstadoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/solicitud_estado")
public class SolicitudEstadoController {
    @Autowired
    private ISolicitudEstadoService service;

    @GetMapping()
    public List<SolicitudEstadoModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<SolicitudEstadoModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public SolicitudEstadoModel save(@RequestBody SolicitudEstadoModel solicitudEstado) {return service.save(solicitudEstado);}
}
