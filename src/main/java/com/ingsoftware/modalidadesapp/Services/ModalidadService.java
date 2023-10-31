package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IModalidadService;
import com.ingsoftware.modalidadesapp.Models.ModalidadModel;
import com.ingsoftware.modalidadesapp.Repositories.IModalidadProyectoGradoRepository;
import com.ingsoftware.modalidadesapp.Repositories.IModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadService implements IModalidadService {
    @Autowired
    private IModalidadRepository modalidadRepository;



    @Override
    public List<ModalidadModel> all() {return modalidadRepository.findAll();}

    @Override
    public Optional<ModalidadModel> findById(Long id) {return modalidadRepository.findById(id);}

    @Override
    public ModalidadModel save(ModalidadModel modalidad) {return modalidadRepository.save(modalidad);}


}
