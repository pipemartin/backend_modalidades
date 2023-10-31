package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.EmpresaModel;
import com.ingsoftware.modalidadesapp.Repositories.IEmpresaRepository;

import java.util.List;
import java.util.Optional;

public interface IEmpresaService {

    //todo métodos básicos (consultar todo, consultar por ID, guardar)
    List<EmpresaModel> all();
    Optional<EmpresaModel> findById(Long id);
    EmpresaModel save(EmpresaModel empresa);

    //todo Listar
    List<IEmpresaRepository.Empresa_Projection>findEmpresa();
}
