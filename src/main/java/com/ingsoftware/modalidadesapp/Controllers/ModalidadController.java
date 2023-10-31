package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IModalidadService;
import com.ingsoftware.modalidadesapp.Models.ModalidadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/modalidad")
public class ModalidadController {
    @Autowired
    private IModalidadService service;

    @GetMapping()
    public List<ModalidadModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<ModalidadModel>show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModalidadModel save(@RequestBody ModalidadModel modalidad) {return service.save(modalidad);}
}
