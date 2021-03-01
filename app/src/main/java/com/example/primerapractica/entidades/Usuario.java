package com.example.primerapractica.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String usuario;
    private String nombre;
    private String apellido;
    private String contraseña;

    public Usuario(Integer id, String nombre, String telefono) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.apellido = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String id) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String telefono) {
        this.apellido = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}


