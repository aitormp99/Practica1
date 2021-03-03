package com.example.primerapractica.entidades;

import java.io.Serializable;
import java.util.Date;

public class Libro implements Serializable {

    private Integer id;
    private String nombre;
    private String Autor;
    private String lanzamiento;

    //constructor clase Libro
    public Libro(Integer id, String nombre, String autor, String fecha) {
        this.id = id;
        this.nombre = nombre;
        Autor = autor;
        this.lanzamiento = fecha;
    }

    public Libro() {

    }


    //metodo obtener id
    public Integer getId() {
        return id;
    }
    //metodo modificar id
    public void setId(Integer id) {
        this.id = id;
    }
    //metodo obtener Nombre libro
    public String getNombre() {
        return nombre;
    }
    //metodo modificar Nombre libro
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //metodo obtener nombre autor
    public String getAutor() {
        return Autor;
    }
    //metodo modificar nombre autor
    public void setAutor(String autor) {
        Autor = autor;
    }
    //metodo obtener fecha lanzamiento
    public String getFecha() {
        return lanzamiento;
    }
    //metodo modificar fecha lanzamiento
    public void setFecha(String fecha) {
        this.lanzamiento = fecha;
    }


}
