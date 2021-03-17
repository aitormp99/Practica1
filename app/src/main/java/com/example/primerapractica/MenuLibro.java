package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MenuLibro extends AppCompatActivity {
    private Button añadirLibro, verListaLibros, abrirGoogleMaps, regresar, notas;
    private EditText coordenadas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(this);

        String idioma = sharedPreferences.getString("idioma","es");
        String color =sharedPreferences.getString("tema","Por Defecto");

        Locale nuevaloc = new Locale(idioma);
        Locale.setDefault(nuevaloc);
        Configuration config = new Configuration();
        config.locale = nuevaloc;

        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        if (color.equals("Por Defecto")){
            setTheme(R.style.PrimeraPracticaAqua);
        }else if (color.equals("Amarillo")){
            setTheme(R.style.PrimeraPracticaAmarillo);
        }else if (color.equals("Celeste")){
            setTheme(R.style.PrimeraPracticaAzul);
        }else if (color.equals("Rojo")){
            setTheme(R.style.PrimeraPracticaRojo);
        }else if (color.equals("Verde")){
            setTheme(R.style.PrimeraPracticaVerde);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        coordenadas = findViewById(R.id.editCoordenadas);
        añadirLibro= findViewById(R.id.botonAñadirLibro);
        verListaLibros = findViewById(R.id.buttonVerListaLibros);
        abrirGoogleMaps = findViewById(R.id.botonMapa);
        regresar = findViewById(R.id.botonRegresar);
        notas = findViewById(R.id.botonNotas);

        //boton que lleva a la actividad InsertarLibro
        añadirLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLibro = new Intent(v.getContext(),InsertarLibro.class);
                startActivity(intentLibro);
            }
        });
        verListaLibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVerLibro = new Intent(v.getContext(),ListaLibros.class);
                startActivity(intentVerLibro);
            }
        });
        abrirGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+coordenadas.getText().toString()));
                startActivity(intent);
            }
        });
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Notas.class);
                startActivity(intent);
            }
        });



    }
}