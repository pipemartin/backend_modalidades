package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IModalidadPosgradoService;
import com.ingsoftware.modalidadesapp.Models.ModalidadPosgradoModel;
import com.ingsoftware.modalidadesapp.Repositories.IModalidadPosgradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadPosgradoService implements IModalidadPosgradoService {
    @Autowired
    private IModalidadPosgradoRepository repository;

    @Override
    public List<ModalidadPosgradoModel> all(){return repository.findAll();}

    @Override
    public Optional<ModalidadPosgradoModel> findById(Long id) {return repository.findById(id);}

    @Override
    public ModalidadPosgradoModel save(ModalidadPosgradoModel modalidadPosgrado) {return repository.save(modalidadPosgrado);}
}
