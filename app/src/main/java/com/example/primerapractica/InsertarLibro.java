package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.preference.PreferenceManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primerapractica.utilidades.Utilidades;

import java.util.Locale;

public class InsertarLibro extends AppCompatActivity {

    private EditText  campoNombre, campoAutor, campoFecha;
    private Button botonRegistro, botonRegresar;
    private PendingIntent pendingIntent;
    private final static  String CHANNEL_ID = "IdCanal" ;
    private final static int NOTIFICACION_ID = 1;
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
        setContentView(R.layout.activity_insertar_libro);


        campoNombre= findViewById(R.id.textLibro);
        campoAutor= findViewById(R.id.textAutor);
        campoFecha=findViewById(R.id.textFecha);

        botonRegistro=findViewById(R.id.botonLibro);
        botonRegresar=findViewById(R.id.botonRegresar2);

        //boton que ejecuta el metodo registrarUsuarios()
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });

        //boton que abre la actividad Menu Libro
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    //metodo que inserta un nuevo libro en la tabla libro
    private void registrarUsuarios(){

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        SQLiteDatabase db= conn.getWritableDatabase();

        try {


            String insert ="insert into "+ Utilidades.TABLA_LIBRO+
                    " ( "+Utilidades.CAMPO_NOMBRE_LIBRO+","+ Utilidades.CAMPO_AUTOR+","+Utilidades.CAMPO_LANZAMIENTO+
                    ") values ('"+campoNombre.getText().toString()+"' ,'"+campoAutor.getText().toString()+"', '"+campoFecha.getText().toString()+"' )";
            db.execSQL(insert);
            createNotificacion();
            limpiar();
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),R.string.ErrorCampoIncorrecto,Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    //metodo para crear una notificacion local al insertar un libro correctamente
    private void createNotificacion() {

        NotificationManager elManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder= new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel elCanal = new NotificationChannel(CHANNEL_ID, "NombreCanal",
                    NotificationManager.IMPORTANCE_DEFAULT);
            elManager.createNotificationChannel(elCanal);
        }
        builder.setSmallIcon(R.drawable.ic_baseline_menu_book_24);
        builder.setContentTitle("Notificacion Local");
        builder.setContentText("Libro con nombre "+campoNombre.getText().toString()+" añadido ");
        builder.setColor(Color.BLACK);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.WHITE,1000,1000);

        elManager.notify(NOTIFICACION_ID, builder.build());
    }

    //metodo que limpia los campos de los editText actividad
    private void limpiar() {

        campoAutor.setText(null);
        campoNombre.setText(null);
        campoFecha.setText(null);
    }
}