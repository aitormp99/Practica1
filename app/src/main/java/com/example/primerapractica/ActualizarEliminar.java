package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primerapractica.utilidades.Utilidades;

public class ActualizarEliminar extends AppCompatActivity {

    private TextView textView1, textView2;
    private EditText campoId, campoNombre, campoApellido, campoContrasena;
    private ConexionSQLiteHelper conn;
    private Button botonBorrar, botonRegresar, botonActulizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_eliminar);

        textView1=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        campoId= findViewById(R.id.TextId);
        campoNombre= findViewById(R.id.TextNombre);
        campoApellido= findViewById(R.id.TextApellido);
        campoContrasena= findViewById(R.id.TextContraseña);

        botonBorrar=findViewById(R.id.buttonBorrar);
        botonActulizar =findViewById(R.id.buttonActualizar);
        botonRegresar=findViewById(R.id.botonRegresar);

        conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        //boton que ejecuta eliminarUsuario()
        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarUsuario();
            }
        });

        //boton que ejecuta actualizarUsuario()
        botonActulizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarUsuario();
            }
        });

        //boton que vuelve a la actividad MainActivity
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(v.getContext(),MainActivity.class);
                startActivity(inicio);
            }
        });



    }
    //metodo para actualizar un usuario de la tabala usuario
    private void actualizarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();
        try {


            String update ="Update "+ Utilidades.TABLA_USUARIO+
                    " set "+Utilidades.CAMPO_NOMBRE+" = '"+campoNombre.getText().toString()+"',"+Utilidades.CAMPO_APELLIDO+" = '"+campoApellido.getText().toString()+"',"+Utilidades.CAMPO_CONTRASENA+" = '"+campoContrasena.getText().toString()
                    +"' where "+Utilidades.CAMPO_USUARIO+" = '"+campoId.getText().toString()+"'";
            db.execSQL(update);
            Toast.makeText(getApplicationContext(),"Usuario modificado correctamente",Toast.LENGTH_LONG).show();
            limpiar();
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }

    }
    //metodo para eliminar un usuario de la tabala usuario
    private void eliminarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();
        try {


            String delete ="delete from "+Utilidades.TABLA_USUARIO+" where "+Utilidades.CAMPO_USUARIO+" = '"+campoId.getText().toString()+"'";
            db.execSQL(delete);
            Toast.makeText(getApplicationContext(),"Usuario borrado correctamente",Toast.LENGTH_LONG).show();
            limpiar();
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
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