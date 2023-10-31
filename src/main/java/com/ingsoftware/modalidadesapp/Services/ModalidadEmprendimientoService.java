package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IModalidadEmprendimientoService;
import com.ingsoftware.modalidadesapp.Models.ModalidadEmprendimientoModel;
import com.ingsoftware.modalidadesapp.Repositories.IModalidadEmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadEmprendimientoService implements IModalidadEmprendimientoService {
    @Autowired
    private IModalidadEmprendimientoRepository repository;

    @Override
    public List<ModalidadEmprendimientoModel> all(){return repository.findAll();}

    @Override
    public Optional<ModalidadEmprendimientoModel> findById(Long id) {return repository.findById(id);}

    @Override
    public ModalidadEmprendimientoModel save(ModalidadEmprendimientoModel modalidadEmprendimiento) {return repository.save(modalidadEmprendimiento);}
}
