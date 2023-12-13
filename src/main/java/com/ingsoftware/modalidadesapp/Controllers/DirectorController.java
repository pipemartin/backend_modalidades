package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IDirectorService;
import com.ingsoftware.modalidadesapp.Models.DirectorModel;
import com.ingsoftware.modalidadesapp.Repositories.IDirectorRepository;
import com.ingsoftware.modalidadesapp.Repositories.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/director")
public class DirectorController {

    @Autowired
    private IDirectorService service;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @GetMapping()
    public List<DirectorModel> all() {return service.all();}

    @GetMapping("{id}")
    public Optional<DirectorModel> show(@PathVariable Long id) {return service.findById(id);}

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public DirectorModel save(@RequestBody DirectorModel director) {return service.save(director);}

    //todo Listar

    @GetMapping("/director_modalidad")
    public ResponseEntity<List<IDirectorRepository.DirectorModalidad_Projection>>obtenerDirectorModalidad(){
        List<IDirectorRepository.DirectorModalidad_Projection>directorData = service.findDirectorModalidad();
        return new ResponseEntity<>(directorData, HttpStatus.OK);
    }

    //todo Actualizar

    @PutMapping("/{id}")
    public ResponseEntity<DirectorModel> updateDirector(@PathVariable Long id, @RequestBody DirectorModel director) {
        DirectorModel updatedDirector = service.updateDirector(id, director);

        if (updatedDirector == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedDirector);
    }

    @GetMapping("/findEstudianteDirector/{codigo}")
    public ResponseEntity<List<IDirectorRepository.EstudianteDirector>> obtenerEstudianteDirector(@PathVariable String codigo) {
        List<IDirectorRepository.EstudianteDirector> estudianteDirectorData = service.findEstudianteDirector(codigo);
        return new ResponseEntity<>(estudianteDirectorData, HttpStatus.OK);
    }
}
