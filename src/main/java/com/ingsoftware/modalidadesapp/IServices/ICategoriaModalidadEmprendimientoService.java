package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.CategoriaModalidadEmprendimientoModel;

import java.util.List;
import java.util.Optional;

public interface ICategoriaModalidadEmprendimientoService {
    //Consultar todo
    List<CategoriaModalidadEmprendimientoModel> all();

    //Consultar por ID
    Optional<CategoriaModalidadEmprendimientoModel> findById(Long id);

    //Guardar
    CategoriaModalidadEmprendimientoModel save(CategoriaModalidadEmprendimientoModel categoria);
}
