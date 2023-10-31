package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IDirectorService;
import com.ingsoftware.modalidadesapp.Models.DirectorModel;
import com.ingsoftware.modalidadesapp.Repositories.IDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService implements IDirectorService {

    @Autowired
    private IDirectorRepository directorRepository;

    //todo métodos básicos (consultar todo, consultar por ID, guardar)

    @Override
    public List<DirectorModel> all(){return directorRepository.findAll();}

    @Override
    public Optional<DirectorModel> findById(Long id) {return directorRepository.findById(id);}

    @Override
    public DirectorModel save(DirectorModel director) {return directorRepository.save(director);}

    //todo Listar
    @Override
    public List<IDirectorRepository.DirectorModalidad_Projection>findDirectorModalidad(){
        return directorRepository.findDirectorModalidad();
    }

    //todo Guardar


    @Override
    public DirectorModel updateDirector(Long id, DirectorModel updatedDirector){
        DirectorModel existingDirector = directorRepository.findById(id).orElse(null);

        if (existingDirector == null) {
            return null; // Puedes manejar este caso de diferentes maneras
        }

        // Actualiza los campos relevantes
        existingDirector.setDir_nombre(updatedDirector.getDir_nombre());
        existingDirector.setDir_primer_apellido(updatedDirector.getDir_primer_apellido());
        existingDirector.setDir_segundo_apellido(updatedDirector.getDir_segundo_apellido());
        existingDirector.setDir_identificacion(updatedDirector.getDir_identificacion());
        existingDirector.setDir_email(updatedDirector.getDir_email());
        existingDirector.setDir_telefono(updatedDirector.getDir_telefono());
        existingDirector.setDir_estado(updatedDirector.getDir_estado());

        return directorRepository.save(existingDirector);
    }

}


