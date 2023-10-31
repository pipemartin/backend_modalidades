package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.ITipoEmpresaService;
import com.ingsoftware.modalidadesapp.Models.TipoEmpresaModel;
import com.ingsoftware.modalidadesapp.Repositories.ITipoEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEmpresaService implements ITipoEmpresaService {
    @Autowired
    private ITipoEmpresaRepository repository;

    @Override
    public List<TipoEmpresaModel> all(){return repository.findAll();}

    @Override
    public Optional<TipoEmpresaModel> findById(Long id){return repository.findById(id);}

    @Override
    public TipoEmpresaModel save(TipoEmpresaModel tipoEmpresa) {return repository.save(tipoEmpresa);}
}
