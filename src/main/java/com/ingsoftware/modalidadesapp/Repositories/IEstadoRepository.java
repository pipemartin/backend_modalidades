package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoRepository extends JpaRepository<EstadoModel, Long> {
}
