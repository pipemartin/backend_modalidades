package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.ICategoriaModalidadEmprendimientoService;
import com.ingsoftware.modalidadesapp.Models.CategoriaModalidadEmprendimientoModel;
import com.ingsoftware.modalidadesapp.Repositories.ICategoriaModalidadEmprendimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaModalidadEmprendimientoService implements ICategoriaModalidadEmprendimientoService {
    @Autowired
    private ICategoriaModalidadEmprendimientoRepository repository;

    @Override
    public List<CategoriaModalidadEmprendimientoModel> all(){return repository.findAll();}

    @Override
    public Optional<CategoriaModalidadEmprendimientoModel> findById(Long id) {return repository.findById(id);}

    @Override
    public CategoriaModalidadEmprendimientoModel save(CategoriaModalidadEmprendimientoModel categoria) {return repository.save(categoria);}
}
