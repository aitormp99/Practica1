package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuLibro extends AppCompatActivity {
    private Button añadirLibro, verListaLibros, abrirGoogleMaps;
    private EditText coordenadas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista);
        coordenadas = findViewById(R.id.editCoordenadas);
        añadirLibro= findViewById(R.id.botonAñadirLibro);
        verListaLibros = findViewById(R.id.buttonVerListaLibros);
        abrirGoogleMaps = findViewById(R.id.botonMapa);
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



    }
}