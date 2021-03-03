package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.primerapractica.entidades.Libro;
import com.example.primerapractica.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class ListaLibros extends AppCompatActivity {


    private TextView textViewNombre;
    private RecyclerView recyclerViewlibro;
    private ArrayList<Libro> listaLibro;


    private ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_libros);

        conn =  new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        listaLibro= new ArrayList<>();

        textViewNombre = findViewById(R.id.textTitulo);

        recyclerViewlibro = (RecyclerView) findViewById(R.id.recyclerLibro);

        recyclerViewlibro.setLayoutManager(new LinearLayoutManager(this));

        consultarListaLibros();

        LibroRecyclerAdapter adapter = new LibroRecyclerAdapter(listaLibro);
        recyclerViewlibro.setAdapter(adapter);


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
