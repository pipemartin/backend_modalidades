package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IEmpresaService;
import com.ingsoftware.modalidadesapp.Models.EmpresaModel;
import com.ingsoftware.modalidadesapp.Repositories.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements IEmpresaService {
    @Autowired
    private IEmpresaRepository repository;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)
    @Override
    public List<EmpresaModel> all(){return repository.findAll();}

    @Override
    public Optional<EmpresaModel> findById(Long id) {return repository.findById(id);}

    @Override
    public EmpresaModel save(EmpresaModel empresa) {return repository.save(empresa);}

    //todo Listar
    @Override
    public List<IEmpresaRepository.Empresa_Projection>findEmpresa(){
        return repository.findEmpresa();
    }
}
