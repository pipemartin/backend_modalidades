package com.ingsoftware.modalidadesapp.IServices;


import com.ingsoftware.modalidadesapp.Models.Usuario;
import com.ingsoftware.modalidadesapp.Models.UsuarioRol;

import java.util.Set;
public interface IUsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);

}
