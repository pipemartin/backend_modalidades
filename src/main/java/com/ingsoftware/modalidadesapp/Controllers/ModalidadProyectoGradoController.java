package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IModalidadProyectoGradoService;
import com.ingsoftware.modalidadesapp.Models.ModalidadProyectoGradoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/modalidad_proyecto_grado")
public class ModalidadProyectoGradoController {
    @Autowired
    private IModalidadProyectoGradoService service;

    @GetMapping()
    public List<ModalidadProyectoGradoModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<ModalidadProyectoGradoModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModalidadProyectoGradoModel save(@RequestBody ModalidadProyectoGradoModel modalidadProyectoGrado) {return service.save(modalidadProyectoGrado);}
}
