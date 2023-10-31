package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.ISedeFacultadService;
import com.ingsoftware.modalidadesapp.Models.SedeFacultadModel;
import com.ingsoftware.modalidadesapp.Repositories.ISedeFacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/sede_facultad")
public class SedeFacultadController {

    @Autowired
    private ISedeFacultadService service;

    @GetMapping()
    public List<SedeFacultadModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<SedeFacultadModel> show(@PathVariable Long id) {return service.findById(id);}


    @GetMapping("/facultad_por_sede/{id}")
    public ResponseEntity<List<ISedeFacultadRepository.SedeFacultadProjection>> obtenerFacultadDataPorIdSede(@PathVariable Long id) {
        List<ISedeFacultadRepository.SedeFacultadProjection> facultadData = service.findFacultadDataByIdSede(id);
        return new ResponseEntity<>(facultadData, HttpStatus.OK);
    }


    @PostMapping
    @ResponseStatus (code = HttpStatus.CREATED)
    public SedeFacultadModel save(@RequestBody SedeFacultadModel sedeFacultad) {return service.save(sedeFacultad);}
}
