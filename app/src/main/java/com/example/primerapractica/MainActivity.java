package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonRegistro, botonLogin, botonActualizarEliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botonRegistro = findViewById(R.id.buttonRegistro);
        botonLogin = findViewById(R.id.botonLogin);
        botonActualizarEliminar= findViewById(R.id.botonActualizarEliminar);

        //boton que ejecuta el metodo openDialog()
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        //boton que abre la actividad Registro
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(v.getContext(),Registro.class);
                startActivity(register);
            }
        });

        //boton que abre la actividad ActualizarEliminar
        botonActualizarEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actualizarEliminar = new Intent(v.getContext(),ActualizarEliminar.class);
                startActivity(actualizarEliminar);
            }
        });
    }

    //metodo que abre el dialogo Login
    public void openDialog(){

        LoginDialog ld = new LoginDialog();
        ld.show(getSupportFragmentManager(),"login dialog");
    }
}