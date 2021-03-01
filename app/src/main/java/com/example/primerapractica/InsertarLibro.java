package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primerapractica.utilidades.Utilidades;

public class InsertarLibro extends AppCompatActivity {

    EditText  campoNombre, campoAutor, campoFecha;
    Button botonRegistro, botonRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_libro);


        campoNombre= findViewById(R.id.textLibro);
        campoAutor= findViewById(R.id.textAutor);
        campoFecha=findViewById(R.id.textFecha);

        botonRegistro=findViewById(R.id.botonLibro);
        botonRegresar=findViewById(R.id.botonRegresar2);

        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(v.getContext(),Lista.class);
                startActivity(principal);
            }
        });

    }
    private void registrarUsuarios(){

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"db_usuarios",null,1);
        SQLiteDatabase db= conn.getWritableDatabase();

        try {


            String insert ="insert into "+ Utilidades.TABLA_LIBRO+
                    " ( "+Utilidades.CAMPO_NOMBRE_LIBRO+","+ Utilidades.CAMPO_AUTOR+","+Utilidades.CAMPO_LANZAMIENTO+
                    ") values ('"+campoNombre.getText().toString()+"' ,'"+campoAutor.getText().toString()+"', '"+campoFecha.getText().toString()+"' )";
            db.execSQL(insert);
            Toast.makeText(getApplicationContext(),"Usuario añadido correctamente",Toast.LENGTH_LONG).show();
            limpiar();
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El id esta repetido",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {

        campoAutor.setText("");
        campoNombre.setText("");
        campoFecha.setText("");
    }
}