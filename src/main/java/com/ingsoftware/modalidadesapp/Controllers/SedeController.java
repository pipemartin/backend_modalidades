package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.ISedeService;
import com.ingsoftware.modalidadesapp.Models.SedeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/sede")
public class SedeController {
    @Autowired
    private ISedeService service;

    @GetMapping()
    public List<SedeModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<SedeModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public  SedeModel save(@RequestBody SedeModel sede) {return service.save(sede);}
}
