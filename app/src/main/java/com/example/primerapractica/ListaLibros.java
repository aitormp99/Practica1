package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.primerapractica.entidades.Libro;
import com.example.primerapractica.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListaLibros extends AppCompatActivity {



    private TextView textViewNombre;
    private RecyclerView recyclerViewlibro;
    private ArrayList<Libro> listaLibro;
    private Button regresar;

    private ConexionSQLiteHelper conn;

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
        setContentView(R.layout.activity_lista_libros);

        conn =  new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        listaLibro= new ArrayList<>();

        textViewNombre = findViewById(R.id.textTitulo);

        recyclerViewlibro = (RecyclerView) findViewById(R.id.recyclerLibro);

        recyclerViewlibro.setLayoutManager(new LinearLayoutManager(this));

        regresar = findViewById(R.id.botonRegresar);

        consultarListaLibros();

        LibroRecyclerAdapter adapter = new LibroRecyclerAdapter(listaLibro);
        recyclerViewlibro.setAdapter(adapter);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void consultarListaLibros() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Libro libro = null;

        Cursor cursor = db.rawQuery("select * from "+Utilidades.TABLA_LIBRO,null);

        while (cursor.moveToNext()){
            libro = new Libro();
            libro.setNombre(cursor.getString(1));
            libro.setAutor(cursor.getString(2));
            libro.setFecha(cursor.getString(3));

            listaLibro.add(libro);
        }
    }


}
