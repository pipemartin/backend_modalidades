package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IEstadoService;
import com.ingsoftware.modalidadesapp.Models.EstadoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/estado")
public class EstadoController {
    @Autowired
    private IEstadoService service;

    @GetMapping()
    public List<EstadoModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<EstadoModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EstadoModel save(@RequestBody EstadoModel estado) {return service.save(estado);}
}
