package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.ISedeService;
import com.ingsoftware.modalidadesapp.Models.SedeModel;
import com.ingsoftware.modalidadesapp.Repositories.ISedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService implements ISedeService {
    @Autowired
    private ISedeRepository repository;

    @Override
    public List<SedeModel> all() {return repository.findAll();}

    @Override
    public Optional<SedeModel> findById(Long id) {return repository.findById(id); }

    @Override
    public SedeModel save(SedeModel sede) {return repository.save(sede);}
}
