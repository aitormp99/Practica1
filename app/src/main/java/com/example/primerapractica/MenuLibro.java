package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuLibro extends AppCompatActivity {
    private Button añadirLibro, verListaLibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        añadirLibro= findViewById(R.id.botonAñadirLibro);
        verListaLibros = findViewById(R.id.buttonVerListaLibros);
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


    }
}