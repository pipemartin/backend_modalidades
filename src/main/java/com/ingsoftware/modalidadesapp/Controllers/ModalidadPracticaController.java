package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IModalidadPracticaService;
import com.ingsoftware.modalidadesapp.Models.ModalidadPracticaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/modalidad_practica")
public class ModalidadPracticaController {
    @Autowired
    private IModalidadPracticaService service;

    @GetMapping()
    public List<ModalidadPracticaModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<ModalidadPracticaModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModalidadPracticaModel save(@RequestBody ModalidadPracticaModel modalidadPractica) {return service.save(modalidadPractica);}
}
