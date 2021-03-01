package com.example.primerapractica.utilidades;

public class Utilidades {
    //constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_USUARIO="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_CONTRASENA="contrasena";
    public static final String CREAR_TABLA_USUARIO="create table " +TABLA_USUARIO+ "("+CAMPO_USUARIO+" TEXT not null primary key, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, "+CAMPO_CONTRASENA+" TEXT)";
}
