package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IModalidadProyectoGradoService;
import com.ingsoftware.modalidadesapp.Models.ModalidadProyectoGradoModel;
import com.ingsoftware.modalidadesapp.Repositories.IModalidadProyectoGradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadProyectoGradoService implements IModalidadProyectoGradoService {
    @Autowired
    private IModalidadProyectoGradoRepository repository;

    @Override
    public List<ModalidadProyectoGradoModel> all(){return repository.findAll();}

    @Override
    public Optional<ModalidadProyectoGradoModel> findById(Long id) {return repository.findById(id);}

    @Override
    public ModalidadProyectoGradoModel save(ModalidadProyectoGradoModel modalidadProyectoGrado) {return repository.save(modalidadProyectoGrado);}
}
