package com.ingsoftware.modalidadesapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuid;
    private String password;
    private String username;
    private String usu_estado;
    private String codigo;
    private Long pro_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Usuario(){

    }

    public Usuario(String username, String password, String codigo) {

        this.username = username;
        this.password = password;
        this.codigo = codigo;
    }

    public Usuario(Long usuid, String username, String password, String usu_estado, String codigo, Long pro_id) {
        this.usuid = usuid;
        this.username = username;
        this.password = password;
        this.usu_estado = usu_estado;
        this.codigo = codigo;
        this.pro_id = pro_id;
    }

    public Long getUsuid() {
        return usuid;
    }

    public void setUsuid(Long usuid) {
        this.usuid = usuid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRoles.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getRol_nombre()));
        });
        return autoridades;
    }

    @Override
    public boolean isEnabled() {
        // Aquí debes proporcionar la lógica para determinar si el usuario está habilitado o no.
        // Por ejemplo, puedes tener un campo en la base de datos que indique si el usuario está habilitado.
        // Retorna true si el usuario está habilitado y false si no lo está.
        return true; // o false, dependiendo de tu lógica.
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsu_estado() {
        return usu_estado;
    }

    public void setUsu_estado(String usu_estado) {
        this.usu_estado = usu_estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }
}
