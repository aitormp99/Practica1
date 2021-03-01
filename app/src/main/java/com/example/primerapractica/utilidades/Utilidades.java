package com.example.primerapractica.utilidades;

public class Utilidades {
    //constantes campos tabla usuario
    //Tabla Usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_USUARIO="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_CONTRASENA="contrasena";
    public static final String CREAR_TABLA_USUARIO="create table " +TABLA_USUARIO+ "("+CAMPO_USUARIO+" TEXT not null primary key, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, "+CAMPO_CONTRASENA+" TEXT)";

    //Tabla Libro
    public static final String TABLA_LIBRO="libro";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE_LIBRO="nombre";
    public static final String CAMPO_AUTOR="autor";
    public static final String CAMPO_LANZAMIENTO="lanzamineto";
    public static final String CREAR_TABLA_LIBRO="create table " +TABLA_LIBRO+ "("+CAMPO_ID+" INTEGER primary key autoincrement, "+CAMPO_NOMBRE_LIBRO+" TEXT, "+CAMPO_AUTOR+" TEXT, "+CAMPO_LANZAMIENTO+" TEXT)";


}
