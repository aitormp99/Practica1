package com.example.primerapractica.entidades;

public class Usuario {

    private Integer usuario;
    private String nombre;
    private String telefono;
    private String contraseña;

    public Usuario(Integer id, String nombre, String telefono) {
        this.usuario = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }

    public Integer getId() {
        return usuario;
    }

    public void setId(Integer id) {
        this.usuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}


