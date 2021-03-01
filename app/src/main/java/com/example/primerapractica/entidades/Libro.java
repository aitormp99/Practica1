package com.example.primerapractica.entidades;

import java.io.Serializable;
import java.util.Date;

public class Libro implements Serializable {

    private Integer id;
    private String nombre;
    private String Autor;
    private Date lanzamiento;

    public Libro(Integer id, String nombre, String autor, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        Autor = autor;
        this.lanzamiento = fecha;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public Date getFecha() {
        return lanzamiento;
    }

    public void setFecha(Date fecha) {
        this.lanzamiento = fecha;
    }


}
