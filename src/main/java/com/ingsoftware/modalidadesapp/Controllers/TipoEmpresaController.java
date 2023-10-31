package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.ITipoEmpresaService;
import com.ingsoftware.modalidadesapp.Models.TipoEmpresaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/tipo_empresa")
public class TipoEmpresaController {
    @Autowired
    private ITipoEmpresaService service;

    @GetMapping()
    public List<TipoEmpresaModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<TipoEmpresaModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus (code = HttpStatus.CREATED)
    public TipoEmpresaModel save(@RequestBody TipoEmpresaModel tipoEmpresa) {return service.save(tipoEmpresa);}
}
