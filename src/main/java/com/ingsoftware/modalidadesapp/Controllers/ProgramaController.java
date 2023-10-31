package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IProgramaService;
import com.ingsoftware.modalidadesapp.Models.ProgramaModel;
import com.ingsoftware.modalidadesapp.Repositories.IProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/programa")
public class ProgramaController {
    @Autowired
    private IProgramaService service;

    @GetMapping()
    public List<ProgramaModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<ProgramaModel> show(@PathVariable Long id) {return service.findById(id);}

    @GetMapping("/programa_por_facultad/{id}")
    public ResponseEntity<List<IProgramaRepository.FacultadProgramaProjection>> obtenerProgramaDataPorFacultad(@PathVariable Long id){
        List<IProgramaRepository.FacultadProgramaProjection> programaData = service.findProgramaDataByIdFacultad(id);
        return new ResponseEntity<>(programaData, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProgramaModel save(@RequestBody ProgramaModel programa){return service.save(programa);}
}
