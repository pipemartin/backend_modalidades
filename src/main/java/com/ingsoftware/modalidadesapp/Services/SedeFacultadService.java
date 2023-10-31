package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.ISedeFacultadService;
import com.ingsoftware.modalidadesapp.Models.SedeFacultadModel;
import com.ingsoftware.modalidadesapp.Repositories.ISedeFacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeFacultadService implements ISedeFacultadService {
    @Autowired
    private ISedeFacultadRepository repository;

    @Override
    public List<SedeFacultadModel> all() {return repository.findAll();}

    @Override
    public Optional<SedeFacultadModel> findById(Long id) {return repository.findById(id);}

    @Override
    public List<ISedeFacultadRepository.SedeFacultadProjection> findFacultadDataByIdSede(Long id) {
        return repository.findFacultadDataByIdSede(id);
    }

    @Override
    public SedeFacultadModel save(SedeFacultadModel sedeFacultadModel) {return repository.save(sedeFacultadModel);}
}
