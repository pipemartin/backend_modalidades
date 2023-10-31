package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IEstudianteProgramaService;
import com.ingsoftware.modalidadesapp.Models.EstudianteProgramaModel;
import com.ingsoftware.modalidadesapp.Repositories.IEstudianteProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteProgramaService implements IEstudianteProgramaService {
    @Autowired
    private IEstudianteProgramaRepository repository;

    @Override
    public List<EstudianteProgramaModel> all(){return repository.findAll();}

    @Override
    public Optional<EstudianteProgramaModel> findById(Long id) {return repository.findById(id);}

    @Override
    public EstudianteProgramaModel save(EstudianteProgramaModel estudiantePrograma) {return repository.save(estudiantePrograma);}
}
