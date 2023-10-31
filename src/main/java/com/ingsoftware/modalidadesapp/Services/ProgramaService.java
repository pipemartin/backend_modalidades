package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IProgramaService;
import com.ingsoftware.modalidadesapp.Models.ProgramaModel;
import com.ingsoftware.modalidadesapp.Repositories.IProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaService implements IProgramaService {
    @Autowired
    private IProgramaRepository repository;

    @Override
    public List<ProgramaModel> all() {return repository.findAll();}

    @Override
    public Optional<ProgramaModel> findById(Long id) {return repository.findById(id);}

    @Override
    public ProgramaModel save(ProgramaModel programa) {return repository.save(programa);}

    @Override
    public  List<IProgramaRepository.FacultadProgramaProjection> findProgramaDataByIdFacultad(Long id){
        return repository.findProgramaDataByIdFacultad(id);
    }
}
