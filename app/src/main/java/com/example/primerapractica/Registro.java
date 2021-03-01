package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primerapractica.utilidades.Utilidades;

import java.sql.SQLData;

public class Registro extends AppCompatActivity {
    EditText campoId, campoNombre, campoApellido, campoContrasena;
    Button botonRegistro, botonRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        campoId= findViewById(R.id.TextId);
        campoNombre= findViewById(R.id.TextNombre);
        campoApellido= findViewById(R.id.TextApellido);
        campoContrasena=findViewById(R.id.TextContraseña);

        botonRegistro=findViewById(R.id.buttonRegistrate);
        botonRegresar=findViewById(R.id.botonRegresar);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(v.getContext(),MainActivity.class);
                startActivity(principal);
            }
        });

    }
    private void registrarUsuarios(){

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"db_usuarios",null,1);
        SQLiteDatabase db= conn.getWritableDatabase();

        try {


            String insert ="insert into "+Utilidades.TABLA_USUARIO+
                    " ( "+Utilidades.CAMPO_USUARIO+","+Utilidades.CAMPO_NOMBRE+","+ Utilidades.CAMPO_APELLIDO+","+Utilidades.CAMPO_CONTRASENA+
                    ") values ('"+campoId.getText().toString()+"', '"+campoNombre.getText().toString()+"' ,'"+campoApellido.getText().toString()+"', '"+campoContrasena.getText().toString()+"' )";
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
        campoId.setText("");
        campoContrasena.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
    }
}