package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.ISolicitudEstadoService;
import com.ingsoftware.modalidadesapp.Models.SolicitudEstadoModel;
import com.ingsoftware.modalidadesapp.Repositories.ISolicitudEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudEstadoService implements ISolicitudEstadoService {
    @Autowired
    private ISolicitudEstadoRepository repository;

    @Override
    public List<SolicitudEstadoModel> all(){return repository.findAll();}

    @Override
    public Optional<SolicitudEstadoModel> findById(Long id) {return repository.findById(id);}

    @Override
    public SolicitudEstadoModel save(SolicitudEstadoModel solicitudEstado) {return repository.save(solicitudEstado);}
}
