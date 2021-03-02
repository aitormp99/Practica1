package com.example.primerapractica.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String usuario;
    private String nombre;
    private String apellido;
    private String contraseña;

    //constructor clase Usuario
    public Usuario(Integer id, String nombre, String telefono) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.apellido = telefono;
    }
    //metodo obtener usuario
    public String getUsuario() {
        return usuario;
    }

    //metodo obtener usuario
    public void setUsuario(String id) {
        this.usuario = usuario;
    }

    //metodo obtener nombre
    public String getNombre() {
        return nombre;
    }

    //metodo obtener nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //metodo obtener apellido
    public String getApellido() {
        return apellido;
    }

    //metodo obtener apellido
    public void setApellido(String telefono) {
        this.apellido = telefono;
    }

    //metodo obtener contraseña
    public String getContraseña() {
        return contraseña;
    }

    //metodo obtener contraseña
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}


