package com.ingsoftware.modalidadesapp.Repositories;

import com.ingsoftware.modalidadesapp.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario findByUsername(String username);

    public Usuario findByCodigo(String codigo);

    public  Usuario findByUsuid(Long id);


}
