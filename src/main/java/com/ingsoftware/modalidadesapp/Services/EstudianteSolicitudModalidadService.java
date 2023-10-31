package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IEstudianteSolicitudModalidadService;
import com.ingsoftware.modalidadesapp.Models.EstudianteSolicitudModalidadModel;
import com.ingsoftware.modalidadesapp.Repositories.IEstudianteSolicitudModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteSolicitudModalidadService implements IEstudianteSolicitudModalidadService {
    @Autowired
    private IEstudianteSolicitudModalidadRepository repository;

    @Override
    public List<EstudianteSolicitudModalidadModel> all(){return repository.findAll();}

    @Override
    public Optional<EstudianteSolicitudModalidadModel> findById(Long id) {return repository.findById(id);}

    @Override
    public EstudianteSolicitudModalidadModel save(EstudianteSolicitudModalidadModel estudianteSolicitudModalidad) {return repository.save(estudianteSolicitudModalidad);}
}
