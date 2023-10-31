package com.ingsoftware.modalidadesapp.IServices;

import com.ingsoftware.modalidadesapp.Models.DirectorModel;
import com.ingsoftware.modalidadesapp.Repositories.IDirectorRepository;

import java.util.List;
import java.util.Optional;

public interface IDirectorService {

    //todo métodos básicos (consultar todo, consultar por ID, guardar)
    List<DirectorModel> all();
    Optional<DirectorModel> findById(Long id);
    DirectorModel save(DirectorModel director);

    //todo Listar
    List<IDirectorRepository.DirectorModalidad_Projection>findDirectorModalidad();

    //todo Actualizar
    DirectorModel updateDirector(Long id, DirectorModel updatedDirector);
}
