package com.example.primerapractica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button botonRegistro, botonLogin, botonActualizarEliminar, botonAjustes;


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
        setContentView(R.layout.activity_main);


        botonRegistro = findViewById(R.id.buttonRegistro);
        botonLogin = findViewById(R.id.botonLogin);
        botonActualizarEliminar= findViewById(R.id.botonActualizarEliminar);
        botonAjustes=findViewById(R.id.ajustes);


        botonAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Preferencias.class);
                startActivity(intent);
                finish();
            }
        });

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