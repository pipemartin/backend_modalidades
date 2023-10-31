package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IModalidadPracticaService;
import com.ingsoftware.modalidadesapp.Models.ModalidadPracticaModel;
import com.ingsoftware.modalidadesapp.Repositories.IModalidadPracticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadPracticaService implements IModalidadPracticaService {
    @Autowired
    private IModalidadPracticaRepository repository;

    @Override
    public List<ModalidadPracticaModel> all(){return repository.findAll();}

    @Override
    public Optional<ModalidadPracticaModel> findById(Long id) {return repository.findById(id);}

    @Override
    public ModalidadPracticaModel save(ModalidadPracticaModel modalidadPractica) {return repository.save(modalidadPractica);}
}
