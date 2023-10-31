package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IEstudianteService;
import com.ingsoftware.modalidadesapp.IServices.ISolicitudModalidadService;
import com.ingsoftware.modalidadesapp.Models.*;
import com.ingsoftware.modalidadesapp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private IEstudianteRepository repository;

    @Autowired
    private IEstudianteProgramaRepository estudianteProgramaRepository;

    @Autowired
    private ISedeRepository sedeRepository;

    @Autowired
    private IProgramaRepository programaRepository;

    @Autowired
    private ISolicitudModalidadRepository solicitudModalidadRepository;

    @Autowired
    private IEstudianteSolicitudModalidadRepository estudianteSolicitudModalidadRepository;

    @Override
    public List<EstudianteModel> all(){
        return repository.findAll();
    }

    @Override
    public Optional<EstudianteModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public EstudianteModel save(EstudianteModel estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public void update(Long id, EstudianteModel estudiante) {
        //op es el objeto que va validar si existe un registro con el id que llega por parametro [id]
        Optional<EstudianteModel> op = repository.findById(id);

        if(op.isEmpty()){
            System.out.println("Dato no encontrado");
        }else{
            //Crear nuevo objeto que va a contener los datos que se van actualizar
            EstudianteModel estudianteUpdate = op.get();
            estudianteUpdate.setEstu_nombre(estudiante.getEstu_nombre());
            estudianteUpdate.setEstu_primer_apellido(estudiante.getEstu_primer_apellido());
            estudianteUpdate.setEstu_segundo_apellido(estudiante.getEstu_segundo_apellido());
            estudianteUpdate.setEstu_eps(estudiante.getEstu_eps());
            estudianteUpdate.setEstu_telefono(estudiante.getEstu_telefono());
            estudianteUpdate.setEstu_nombre_acudiente(estudiante.getEstu_nombre_acudiente());
            estudianteUpdate.setEstu_telefono_acudiente(estudiante.getEstu_telefono_acudiente());

            //Actualizar el objeto
            repository.save(estudianteUpdate);
        }
    }

    @Override
    public void saveEstudiantePrograma(List<EstudianteProgramaRequest> datosEstudiantes){

        for (EstudianteProgramaRequest datos : datosEstudiantes){

            EstudianteModel nuevoEstudiante = new EstudianteModel();
            nuevoEstudiante.setEstu_telefono_acudiente(datos.getTelefoAcud());
            nuevoEstudiante.setEstu_telefono(datos.getTelefono());
            nuevoEstudiante.setEstu_segundo_apellido(datos.getSegundoApell());
            nuevoEstudiante.setEstu_primer_apellido(datos.getPrimerApell());
            nuevoEstudiante.setEstu_identificacion(datos.getIdentificacion());
            nuevoEstudiante.setEstu_eps(datos.getEps());
            nuevoEstudiante.setEstu_nombre(datos.getNombre());
            nuevoEstudiante.setEstu_nombre_acudiente(datos.getNombreAcud());

            repository.save(nuevoEstudiante);

            Long llave = repository.findLastInsertedId();
            Optional<EstudianteModel> estudiante = repository.findById(llave);
            Optional<SedeModel> idSede = sedeRepository.findById(datos.getSede());
            Optional<ProgramaModel> idPrograma = programaRepository.findById(datos.getPrograma());

            EstudianteProgramaModel nuevoEstudianteProg = new EstudianteProgramaModel();
            nuevoEstudianteProg.setEsp_codigo(datos.getCodigo());
            nuevoEstudianteProg.setEsp_email(datos.getEmail());
            nuevoEstudianteProg.setEstu_id(estudiante.get());
            nuevoEstudianteProg.setSed_id(idSede.get());
            nuevoEstudianteProg.setPro_id(idPrograma.get());

            estudianteProgramaRepository.save(nuevoEstudianteProg);

            Long llaveSolicitud = solicitudModalidadRepository.findLastInsertedId();
            Optional<SolicitudModalidadModel> idSolicitud = solicitudModalidadRepository.findById(llaveSolicitud);
            EstudianteSolicitudModalidadModel nuevoEstudianteSolicitud = new EstudianteSolicitudModalidadModel();
            nuevoEstudianteSolicitud.setSolm_id(idSolicitud.get());
            nuevoEstudianteSolicitud.setEstu_id(estudiante.get());

            estudianteSolicitudModalidadRepository.save(nuevoEstudianteSolicitud);


        }








    }

    @Override
    public List<IEstudianteRepository.EstudianteProyectoProjection> findEstudianteProyecto(Long id) {
        return repository.findEstudianteProyecto(id);
    }
}
