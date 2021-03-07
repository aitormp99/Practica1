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
    private EditText campoId, campoNombre, campoApellido, campoContrasena;
    private Button botonRegistro, botonRegresar;
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

        //boton que ejecuta el metodo registrarUsuario()
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });

        //boton que hace volver a la actividad MainActivity
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent principal = new Intent(v.getContext(),MainActivity.class);
                startActivity(principal);
            }
        });

    }
    //metodo para insertar un usuario en la tabla usuario
    private void registrarUsuarios(){

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db= conn.getWritableDatabase();

        try {


            String insert ="insert into "+Utilidades.TABLA_USUARIO+
                    " ( "+Utilidades.CAMPO_USUARIO+","+Utilidades.CAMPO_NOMBRE+","+ Utilidades.CAMPO_APELLIDO+","+Utilidades.CAMPO_CONTRASENA+
                    ") values ('"+campoId.getText().toString()+"', '"+campoNombre.getText().toString()+"' ,'"+campoApellido.getText().toString()+"', '"+campoContrasena.getText().toString()+"' )";
            db.execSQL(insert);
            Toast.makeText(getApplicationContext(),R.string.UsusarioAñadidoCorrectamente,Toast.LENGTH_LONG).show();
            limpiar();
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),R.string.idRepetido,Toast.LENGTH_LONG).show();
            limpiar();
        }


    }
    //metodo que limpia los campos de los editText actividad
    private void limpiar() {
        campoId.setText(null);
        campoContrasena.setText(null);
        campoNombre.setText(null);
        campoApellido.setText(null);
    }
}