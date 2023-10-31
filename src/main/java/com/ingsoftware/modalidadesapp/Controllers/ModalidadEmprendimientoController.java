package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IModalidadEmprendimientoService;
import com.ingsoftware.modalidadesapp.Models.ModalidadEmprendimientoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/modalidad_emprendimiento")
public class ModalidadEmprendimientoController {
    @Autowired
    private IModalidadEmprendimientoService service;

    @GetMapping()
    public List<ModalidadEmprendimientoModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<ModalidadEmprendimientoModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModalidadEmprendimientoModel save(@RequestBody ModalidadEmprendimientoModel modalidadEmprendimiento) {return service.save(modalidadEmprendimiento);}
}
