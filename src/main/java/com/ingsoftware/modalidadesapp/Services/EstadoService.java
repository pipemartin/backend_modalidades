package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IEstadoService;
import com.ingsoftware.modalidadesapp.Models.EstadoModel;
import com.ingsoftware.modalidadesapp.Repositories.IEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService implements IEstadoService {
    @Autowired
    private IEstadoRepository repository;

    @Override
    public List<EstadoModel> all(){return repository.findAll();}

    @Override
    public Optional<EstadoModel> findById(Long id) {return repository.findById(id);}

    @Override
    public EstadoModel save(EstadoModel estado) {return repository.save(estado);}
}
