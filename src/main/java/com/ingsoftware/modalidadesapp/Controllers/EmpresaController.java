package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IEmpresaService;
import com.ingsoftware.modalidadesapp.Models.EmpresaModel;
import com.ingsoftware.modalidadesapp.Repositories.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/empresa")
public class EmpresaController {
    @Autowired
    private IEmpresaService service;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @GetMapping()
    public List<EmpresaModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<EmpresaModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmpresaModel save(@RequestBody EmpresaModel empresa) {return service.save(empresa);}

    //todo Listar
    @GetMapping("/empresa_modalidad")
    public ResponseEntity<List<IEmpresaRepository.Empresa_Projection>>obtenerEmpresa(){
        List<IEmpresaRepository.Empresa_Projection>empresaData = service.findEmpresa();
        return new ResponseEntity<>(empresaData, HttpStatus.OK);
    }
}
