package com.ingsoftware.modalidadesapp.Models;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Long rol_id;
    private String rol_nombre;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    public Rol(){

    }

    public Rol(Long rol_id, String rol_nombre) {
        this.rol_id = rol_id;
        this.rol_nombre = rol_nombre;
    }

    public Long getRol_id() {
        return rol_id;
    }

    public void setRolId(Long rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }
}