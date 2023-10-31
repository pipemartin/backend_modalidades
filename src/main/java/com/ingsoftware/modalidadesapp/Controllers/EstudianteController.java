package com.ingsoftware.modalidadesapp.Controllers;

import com.ingsoftware.modalidadesapp.IServices.IEstudianteService;
import com.ingsoftware.modalidadesapp.Models.EstudianteModel;
import com.ingsoftware.modalidadesapp.Models.EstudianteProgramaRequest;
import com.ingsoftware.modalidadesapp.Repositories.IEstudianteRepository;
import com.ingsoftware.modalidadesapp.Repositories.ISedeFacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/estudiante")
public class EstudianteController {
    @Autowired
    private IEstudianteService service;

    @GetMapping()
    public List<EstudianteModel> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public Optional<EstudianteModel> show(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EstudianteModel save(@RequestBody EstudianteModel estudiante) {
        return service.save(estudiante);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody EstudianteModel estudiante) {
        service.update(id, estudiante);
    }

    @PostMapping("/crear_estudiante_programa")
    public ResponseEntity<String> crearEstudiantePrograma(@RequestBody List<EstudianteProgramaRequest> estudianteProgramaRequest){


        service.saveEstudiantePrograma(estudianteProgramaRequest);

        return ResponseEntity.ok("Estudiante y estudiate_programa creados exitosamente");
    }

    @GetMapping("/estudiante_proyecto/{id}")
    public ResponseEntity<List<IEstudianteRepository.EstudianteProyectoProjection>> obtenerEstudianteProyecto(@PathVariable Long id) {
        List<IEstudianteRepository.EstudianteProyectoProjection> estudianteProyectoData = service.findEstudianteProyecto(id);
        return new ResponseEntity<>(estudianteProyectoData, HttpStatus.OK);
    }
}
