package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IFacultadService;
import com.ingsoftware.modalidadesapp.Models.FacultadModel;
import com.ingsoftware.modalidadesapp.Repositories.IFacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService implements IFacultadService {
    @Autowired
    private IFacultadRepository repository;

    @Override
    public List<FacultadModel> all() {return repository.findAll();}

    @Override
    public Optional<FacultadModel> findById(Long id) {return repository.findById(id);}

    @Override
    public FacultadModel save(FacultadModel facultad) {return repository.save(facultad);}
}
