package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IModalidadPosgradoService;
import com.ingsoftware.modalidadesapp.Models.ModalidadPosgradoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/modalidad_posgrado")
public class ModalidadPosgradoController {
    @Autowired
    private IModalidadPosgradoService service;

    @GetMapping()
    public List<ModalidadPosgradoModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<ModalidadPosgradoModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModalidadPosgradoModel save(@RequestBody ModalidadPosgradoModel modalidadPosgrado) {return service.save(modalidadPosgrado);}
}
