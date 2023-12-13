package com.ingsoftware.modalidadesapp.Services;

import com.ingsoftware.modalidadesapp.IServices.IUsuarioService;
import com.ingsoftware.modalidadesapp.Models.Usuario;
import com.ingsoftware.modalidadesapp.Models.UsuarioRol;
import com.ingsoftware.modalidadesapp.Repositories.IRolRepository;
import com.ingsoftware.modalidadesapp.Repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }


    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usu_id) {
        usuarioRepository.deleteById(usu_id);
    }

    @Override
    public boolean updateUsuario(String username, String newPassword){
        //op es el objeto que va validar si existe un registro con el id que llega por parametro [id]
        Usuario usuarioLocal =  usuarioRepository.findByUsername(username);
        System.out.println(username);
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            usuarioLocal.setPassword(passwordEncoder.encode(newPassword));
            usuarioRepository.save(usuarioLocal);
            return true;
        } else {
            System.out.println("El usuario No existe");
            return false;
        }
    }

    @Override
    public boolean updateCodigo(Integer idUser, String username, String codigo){
        // Convertir la cadena a long
        long idUserLong = idUser.longValue();
        //op es el objeto que va validar si existe un registro con el id que llega por parametro [id]
        Usuario usuarioLocal =  usuarioRepository.findByUsuid(idUserLong);
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            usuarioLocal.setUsername(username);
            usuarioLocal.setCodigo(codigo);
            usuarioRepository.save(usuarioLocal);
            return true;
        } else {
            System.out.println("El usuario No existe");
            return false;
        }
    }

    @Override
    public Usuario estudianteCodigo(String codigoEstudiante) {
        Usuario usuarioLocal = usuarioRepository.findByCodigo(codigoEstudiante);
        return usuarioLocal;
    }

    @Override
    public Usuario estudianteUsername(String usernameEstudiante) {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usernameEstudiante);
        return usuarioLocal;
    }

}
