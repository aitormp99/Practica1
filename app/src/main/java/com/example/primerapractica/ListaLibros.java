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

    private AppCompatActivity activity = ListaLibros.this;
    private TextView textViewNombre;
    private RecyclerView recyclerViewlibro;
    private List<Libro> listaLibro;
    private LibroRecyclerAdapter LibroRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_libros);

        textViewNombre = findViewById(R.id.textTitulo);
        recyclerViewlibro = (RecyclerView) findViewById(R.id.recyclerViewLibro);

        listaLibro = new ArrayList<>();
        LibroRecyclerAdapter = new LibroRecyclerAdapter(listaLibro);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recyclerViewlibro.setLayoutManager(lm);
        recyclerViewlibro.setItemAnimator(new DefaultItemAnimator());
        recyclerViewlibro.setHasFixedSize(true);
        recyclerViewlibro.setAdapter(LibroRecyclerAdapter);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios", null, 1);
        getDataFromSQLite();
    }

    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @SuppressLint("StaticFieldLeak")
            @Override
            protected Void doInBackground(Void... params) {


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                LibroRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}