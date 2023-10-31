package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IFacultadService;
import com.ingsoftware.modalidadesapp.Models.FacultadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/facultad")
public class FacultadController {
    @Autowired
    private IFacultadService service;

    @GetMapping()
    public List<FacultadModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<FacultadModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FacultadModel save(@RequestBody FacultadModel facultad) {return service.save(facultad);}
}
