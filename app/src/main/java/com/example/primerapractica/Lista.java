package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lista extends AppCompatActivity {
    Button añadirLibro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        añadirLibro= findViewById(R.id.botonAñadirLibro);

        añadirLibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLibro = new Intent(v.getContext(),InsertarLibro.class);
                startActivity(intentLibro);
            }
        });
    }
}