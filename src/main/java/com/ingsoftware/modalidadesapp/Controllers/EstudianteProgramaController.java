package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IEstudianteProgramaService;
import com.ingsoftware.modalidadesapp.Models.EstudianteProgramaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/estudiante_programa")
public class EstudianteProgramaController {
    @Autowired
    private IEstudianteProgramaService service;

    @GetMapping()
    public List<EstudianteProgramaModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<EstudianteProgramaModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EstudianteProgramaModel save(@RequestBody EstudianteProgramaModel estudiantePrograma) {return service.save(estudiantePrograma);}
}
