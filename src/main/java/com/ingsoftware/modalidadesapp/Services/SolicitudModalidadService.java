package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.ISolicitudModalidadService;
import com.ingsoftware.modalidadesapp.Models.*;
import com.ingsoftware.modalidadesapp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudModalidadService implements ISolicitudModalidadService {
    @Autowired
    private ISolicitudModalidadRepository solicitudModalidadRepository;

    @Autowired
    private IModalidadProyectoGradoRepository modalidadProyectoGradoRepository;

    @Autowired
    private IModalidadRepository modalidadRepository;

    @Autowired
    private IEstadoRepository estadoRepository;

    @Autowired
    private ISolicitudEstadoRepository solicitudEstadoRepository;

    @Autowired
    private IModalidadPosgradoRepository modalidadPosgradoRepository;

    @Autowired
    private IModalidadPracticaRepository modalidadPracticaRepository;

    @Autowired
    private
    IModalidadEmprendimientoRepository modalidadEmprendimientoRepository;

    @Autowired
    private
    ICategoriaModalidadEmprendimientoRepository categoriaModalidadEmprendimientoRepository;

    @Autowired
    private
    ITipoEmpresaRepository tipoEmpresaRepository;

    @Autowired
    private
    IEmpresaRepository empresaRepository;

    @Override
    public List<SolicitudModalidadModel> all(){return solicitudModalidadRepository.findAll();}

    @Override
    public Optional<SolicitudModalidadModel> findById(Long id) {return solicitudModalidadRepository.findById(id);}

    @Override
    public SolicitudModalidadModel save(SolicitudModalidadModel solicitudModalidad) {return solicitudModalidadRepository.save(solicitudModalidad);}


    //TODO Para guardar en tablas relacionadas con Modalidad PROYECTO DE GRADO
    @Override
    public void saveSolicitudProyecto(String pdfFormulario, Long tipoModalidad, String titulo){

        // Guardar en tabla: solicitud_modalidad
        SolicitudModalidadModel nuevaSolicitud = new SolicitudModalidadModel();
        //ModalidadModel modalidad = modalidadRepository.findById(tipoModalidad)
         //       .orElseThrow(() -> new IllegalArgumentException("Tipo de modalidad no encontrado"));
        Optional<ModalidadModel> modalidad = modalidadRepository.findById(tipoModalidad);

        nuevaSolicitud.setMod_id(modalidad.get());
        nuevaSolicitud.setSolm_form_pdf(pdfFormulario);

        solicitudModalidadRepository.save(nuevaSolicitud);

        // Guardar en tabla: proyecto_grado
        Long llave = solicitudModalidadRepository.findLastInsertedId();
        Optional<SolicitudModalidadModel> solicitud = solicitudModalidadRepository.findById(llave);

        ModalidadProyectoGradoModel nuevoProyecto = new ModalidadProyectoGradoModel();

        nuevoProyecto.setPro_titulo(titulo);
        nuevoProyecto.setSolicitudModalidad(solicitud.get());

        modalidadProyectoGradoRepository.save(nuevoProyecto);

        // Guardar en tabla: solicitud_modalidad_estado
        Date fechaSolicitud = new Date();
        Long estado = 7L;
        Optional<EstadoModel> idEstado = estadoRepository.findById(estado);

        SolicitudEstadoModel nuevaSolicitudModalidaEstado = new SolicitudEstadoModel();

        nuevaSolicitudModalidaEstado.setSest_fecha(fechaSolicitud);
        nuevaSolicitudModalidaEstado.setSolm_id(solicitud.get());
        nuevaSolicitudModalidaEstado.setEst_id(idEstado.get());

        solicitudEstadoRepository.save(nuevaSolicitudModalidaEstado);
    }

    //TODO Para guardar en tablas relacionadas con Modalidad PLAN COMPLEMENTARIO EN PROGRAMA DE POSGRADO
    @Override
    public void saveSolicitudPosgrado(String pdfFormulario, Long tipoModalidad, String nombrePosgrado, String pdfPosgrado){ //variables que se reciben del formulario

        // Guardar en tabla: solicitud_modalidad
        SolicitudModalidadModel nuevaSolicitud = new SolicitudModalidadModel();

        Optional<ModalidadModel> modalidad = modalidadRepository.findById(tipoModalidad);

        nuevaSolicitud.setMod_id(modalidad.get());
        nuevaSolicitud.setSolm_form_pdf(pdfFormulario);

        solicitudModalidadRepository.save(nuevaSolicitud);

        // Guardar en tabla: posgrado
        Long llave = solicitudModalidadRepository.findLastInsertedId();
        Optional<SolicitudModalidadModel> solicitud = solicitudModalidadRepository.findById(llave);

        ModalidadPosgradoModel nuevoPosgrado = new ModalidadPosgradoModel();

        nuevoPosgrado.setPos_nombre_posgrado(nombrePosgrado);
        nuevoPosgrado.setPos_pdf(pdfPosgrado);
        nuevoPosgrado.setSolicitudModalidad(solicitud.get());

        modalidadPosgradoRepository.save(nuevoPosgrado);

        // Guardar en tabla: solicitud_modalidad_estado
        Date fechaSolicitud = new Date();
        Long estado = 7L;
        Optional<EstadoModel> idEstado = estadoRepository.findById(estado);

        SolicitudEstadoModel nuevaSolicitudModalidaEstado = new SolicitudEstadoModel();

        nuevaSolicitudModalidaEstado.setSest_fecha(fechaSolicitud);
        nuevaSolicitudModalidaEstado.setSolm_id(solicitud.get());
        nuevaSolicitudModalidaEstado.setEst_id(idEstado.get());

        solicitudEstadoRepository.save(nuevaSolicitudModalidaEstado);
    }

    //TODO Para guardar en tablas relacionadas con Modalidad PRÁCTICA PROFESIONAL
    @Override
    public void saveSolicitudPractica(String pdfFormulario, Long tipoModalidad, String pdfPractica, String pas_nombre_empresa,
                                      String pas_direccion_empresa, String pas_telefono_empresa, String pas_actividad_empresa,
                                      String pas_nombre_responsable, String pas_primer_apellido_responsable,
                                      String pas_segundo_apellido_responsable, String pas_cargo_responsable,
                                      String pas_telefono_responsable, String pas_email_responsable, Long tipe_id){

        // Guardar en tabla: solicitud_modalidad
        SolicitudModalidadModel nuevaSolicitud = new SolicitudModalidadModel();

        Optional<ModalidadModel> modalidad = modalidadRepository.findById(tipoModalidad);

        nuevaSolicitud.setMod_id(modalidad.get());
        nuevaSolicitud.setSolm_form_pdf(pdfFormulario);

        solicitudModalidadRepository.save(nuevaSolicitud);

        // Guardar en tabla: practica
        Long llave = solicitudModalidadRepository.findLastInsertedId(); //para encontrar el id de solicitud recién creado
        Optional<SolicitudModalidadModel> solicitud = solicitudModalidadRepository.findById(llave);

        ModalidadPracticaModel nuevaPractica = new ModalidadPracticaModel();

        nuevaPractica.setPra_contrato_pdf(pdfPractica);
        nuevaPractica.setSolicitudModalidad(solicitud.get());

        modalidadPracticaRepository.save(nuevaPractica);

        // Guardar en tabla: solicitud_modalidad_estado
        Date fechaSolicitud = new Date();
        Long estado = 7L;
        Optional<EstadoModel> idEstado = estadoRepository.findById(estado);

        SolicitudEstadoModel nuevaSolicitudModalidaEstado = new SolicitudEstadoModel();

        nuevaSolicitudModalidaEstado.setSest_fecha(fechaSolicitud);
        nuevaSolicitudModalidaEstado.setSolm_id(solicitud.get());
        nuevaSolicitudModalidaEstado.setEst_id(idEstado.get());

        solicitudEstadoRepository.save(nuevaSolicitudModalidaEstado);

        //Guardar en tabla: empresa
        Optional<TipoEmpresaModel> idTipo = tipoEmpresaRepository.findById(tipe_id); //busca el id en la tabla tipoEmpresa
        EmpresaModel nuevaEmpresa = new EmpresaModel();

        nuevaEmpresa.setPas_actividad_empresa(pas_actividad_empresa);
        nuevaEmpresa.setPas_direccion_empresa(pas_direccion_empresa);
        nuevaEmpresa.setPas_nombre_empresa(pas_nombre_empresa);
        nuevaEmpresa.setPas_telefono_empresa(pas_telefono_empresa);
        nuevaEmpresa.setPas_nombre_responsable(pas_nombre_responsable);
        nuevaEmpresa.setPas_cargo_responsable(pas_cargo_responsable);
        nuevaEmpresa.setPas_primer_apellido_responsable(pas_primer_apellido_responsable);
        nuevaEmpresa.setPas_segundo_apellido_responsable(pas_segundo_apellido_responsable);
        nuevaEmpresa.setPas_telefono_responsable(pas_telefono_responsable);
        nuevaEmpresa.setPas_email_responsable(pas_email_responsable);
        nuevaEmpresa.setTipe_id(idTipo.get());
        nuevaEmpresa.setSolicitudModalidad(solicitud.get());

        empresaRepository.save(nuevaEmpresa);
    }

    //TODO Para guardar en tablas relacionadas con Modalidad PASATÍA SUPERVISADA
    @Override
    public void saveSolicitudPasantia(String pdfFormulario, Long tipoModalidad, String pas_nombre_empresa,
                                      String pas_direccion_empresa, String pas_telefono_empresa, String pas_actividad_empresa,
                                      String pas_nombre_responsable, String pas_primer_apellido_responsable,
                                      String pas_segundo_apellido_responsable, String pas_cargo_responsable,
                                      String pas_telefono_responsable, String pas_email_responsable, Long tipe_id){

        // Guardar en tabla: solicitud_modalidad
        SolicitudModalidadModel nuevaSolicitud = new SolicitudModalidadModel();

        Optional<ModalidadModel> modalidad = modalidadRepository.findById(tipoModalidad);

        nuevaSolicitud.setMod_id(modalidad.get());
        nuevaSolicitud.setSolm_form_pdf(pdfFormulario);

        solicitudModalidadRepository.save(nuevaSolicitud);


        Long llave = solicitudModalidadRepository.findLastInsertedId(); //para encontrar el id de solicitud recién creado
        Optional<SolicitudModalidadModel> solicitud = solicitudModalidadRepository.findById(llave);


        // Guardar en tabla: solicitud_modalidad_estado
        Date fechaSolicitud = new Date();
        Long estado = 7L;
        Optional<EstadoModel> idEstado = estadoRepository.findById(estado);

        SolicitudEstadoModel nuevaSolicitudModalidaEstado = new SolicitudEstadoModel();

        nuevaSolicitudModalidaEstado.setSest_fecha(fechaSolicitud);
        nuevaSolicitudModalidaEstado.setSolm_id(solicitud.get());
        nuevaSolicitudModalidaEstado.setEst_id(idEstado.get());

        solicitudEstadoRepository.save(nuevaSolicitudModalidaEstado);

        //Guardar en tabla: empresa
        Optional<TipoEmpresaModel> idTipo = tipoEmpresaRepository.findById(tipe_id); //busca el id en la tabla tipoEmpresa
        EmpresaModel nuevaEmpresa = new EmpresaModel();

        nuevaEmpresa.setPas_actividad_empresa(pas_actividad_empresa);
        nuevaEmpresa.setPas_direccion_empresa(pas_direccion_empresa);
        nuevaEmpresa.setPas_nombre_empresa(pas_nombre_empresa);
        nuevaEmpresa.setPas_telefono_empresa(pas_telefono_empresa);
        nuevaEmpresa.setPas_nombre_responsable(pas_nombre_responsable);
        nuevaEmpresa.setPas_cargo_responsable(pas_cargo_responsable);
        nuevaEmpresa.setPas_primer_apellido_responsable(pas_primer_apellido_responsable);
        nuevaEmpresa.setPas_segundo_apellido_responsable(pas_segundo_apellido_responsable);
        nuevaEmpresa.setPas_telefono_responsable(pas_telefono_responsable);
        nuevaEmpresa.setPas_email_responsable(pas_email_responsable);
        nuevaEmpresa.setTipe_id(idTipo.get());
        nuevaEmpresa.setSolicitudModalidad(solicitud.get());

        empresaRepository.save(nuevaEmpresa);
    }


    //TODO Para guardar en tablas relacionadas con Modalidad EMPRENDIMIENTO Y FORTALECIMIENTO DE EMPRESA
    @Override
    public void saveSolicitudEmprendimiento(String pdfFormulario, Long tipoModalidad, Long categoria, String pdfEmprendimiento){

        // Guardar en tabla: solicitud_modalidad
        SolicitudModalidadModel nuevaSolicitud = new SolicitudModalidadModel();

        Optional<ModalidadModel> modalidad = modalidadRepository.findById(tipoModalidad);

        nuevaSolicitud.setMod_id(modalidad.get());
        nuevaSolicitud.setSolm_form_pdf(pdfFormulario);

        solicitudModalidadRepository.save(nuevaSolicitud);

        // Guardar en tabla: emprendimiento
        Long llave = solicitudModalidadRepository.findLastInsertedId();
        Optional<SolicitudModalidadModel> solicitud = solicitudModalidadRepository.findById(llave);
        Optional<CategoriaModalidadEmprendimientoModel> idCategoria = categoriaModalidadEmprendimientoRepository.findById(categoria);

        ModalidadEmprendimientoModel nuevoEmprendimiento = new ModalidadEmprendimientoModel();

        nuevoEmprendimiento.setEmp_categoria_pdf(pdfEmprendimiento);
        nuevoEmprendimiento.setCat_id(idCategoria.get());
        nuevoEmprendimiento.setSolicitudModalidad(solicitud.get());

        modalidadEmprendimientoRepository.save(nuevoEmprendimiento);

        // Guardar en tabla: solicitud_modalidad_estado
        Date fechaSolicitud = new Date();
        Long estado = 7L;
        Optional<EstadoModel> idEstado = estadoRepository.findById(estado);

        SolicitudEstadoModel nuevaSolicitudModalidaEstado = new SolicitudEstadoModel();

        nuevaSolicitudModalidaEstado.setSest_fecha(fechaSolicitud);
        nuevaSolicitudModalidaEstado.setSolm_id(solicitud.get());
        nuevaSolicitudModalidaEstado.setEst_id(idEstado.get());

        solicitudEstadoRepository.save(nuevaSolicitudModalidaEstado);
    }
    //TODO Para guardar en tablas relacionadas con Modalidades (SEMILLERO DE INVESTIGACIÓN,
    // PRODUCCIÓN ACADÉMICA DE ALTO NIVEL, PORTAFOLIO PROFESIONAL y SEMINARIO)
    @Override
    public void saveSolicitudOtras(String pdfFormulario, Long tipoModalidad){

        // Guardar en tabla: solicitud_modalidad
        SolicitudModalidadModel nuevaSolicitud = new SolicitudModalidadModel();

        Optional<ModalidadModel> modalidad = modalidadRepository.findById(tipoModalidad);

        nuevaSolicitud.setMod_id(modalidad.get());
        nuevaSolicitud.setSolm_form_pdf(pdfFormulario);

        solicitudModalidadRepository.save(nuevaSolicitud);

        // Guardar en tabla: solicitud_modalidad_estado
        Long llave = solicitudModalidadRepository.findLastInsertedId();
        Optional<SolicitudModalidadModel> solicitud = solicitudModalidadRepository.findById(llave);

        Date fechaSolicitud = new Date();
        Long estado = 7L;
        Optional<EstadoModel> idEstado = estadoRepository.findById(estado);

        SolicitudEstadoModel nuevaSolicitudModalidaEstado = new SolicitudEstadoModel();

        nuevaSolicitudModalidaEstado.setSest_fecha(fechaSolicitud);
        nuevaSolicitudModalidaEstado.setSolm_id(solicitud.get());
        nuevaSolicitudModalidaEstado.setEst_id(idEstado.get());

        solicitudEstadoRepository.save(nuevaSolicitudModalidaEstado);
    }

}