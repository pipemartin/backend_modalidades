package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.ICategoriaModalidadEmprendimientoService;
import com.ingsoftware.modalidadesapp.Models.CategoriaModalidadEmprendimientoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/categoria")
public class CategoriaModalidadEmprendimientoController {
    @Autowired
    private ICategoriaModalidadEmprendimientoService service;

    @GetMapping()
    public List<CategoriaModalidadEmprendimientoModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<CategoriaModalidadEmprendimientoModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CategoriaModalidadEmprendimientoModel save(@RequestBody CategoriaModalidadEmprendimientoModel categoria) {return service.save(categoria);}
}
