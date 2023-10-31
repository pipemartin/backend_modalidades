package com.ingsoftware.modalidadesapp.Controllers;
import com.ingsoftware.modalidadesapp.IServices.IUsuarioService;
import com.ingsoftware.modalidadesapp.Models.Usuario;
import com.ingsoftware.modalidadesapp.Models.Rol;
import com.ingsoftware.modalidadesapp.Models.UsuarioRol;
import com.ingsoftware.modalidadesapp.Models.JwtRequest;
import com.ingsoftware.modalidadesapp.Models.JwtResponse;
import com.ingsoftware.modalidadesapp.Services.UserDetailsServiceImpl;
import com.ingsoftware.modalidadesapp.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("api/user")
public class AuthenticationController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private JwtUtils jwtUtils;

    public AuthenticationController() {
    }

    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario usuario) throws Exception{
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(1L);
        rol.setRol_nombre("ADMINISTRADOR");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setUsu_estado("1");
        usuario.setPro_id(1L);
        //System.out.println(usuario.getUsu_estado() + usuario.getUsu_nombre() +  usuario.getUsername() +  usuario.getUsu_email()+"\n");

        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
        } catch (Exception exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username, String password) throws  Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw new Exception("Usuario Deshabilitado" + exception.getMessage());
        } catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas"+e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public ResponseEntity<Usuario> obtenerUsuarioActual(Principal principal){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(principal.getName());
        if (userDetails instanceof Usuario) {
            Usuario usuario = (Usuario) userDetails;
            return ResponseEntity.ok(usuario);
        } else {
            // En este caso, el usuario no es una instancia de Usuario.
            // Puedes manejar esta situación de acuerdo a tus necesidades.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
