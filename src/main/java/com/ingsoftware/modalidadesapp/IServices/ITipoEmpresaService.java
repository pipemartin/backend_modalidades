package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.TipoEmpresaModel;

import java.util.List;
import java.util.Optional;

public interface ITipoEmpresaService {
    //Consultar todo
    List<TipoEmpresaModel> all();

    //Consultar por ID
    Optional<TipoEmpresaModel> findById(Long id);

    //Guardar
    TipoEmpresaModel save(TipoEmpresaModel tipo);
}
