package com.example.primerapractica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonRegistro, botonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"db_usuarios",null,1);

        botonRegistro = findViewById(R.id.buttonRegistro);
        botonLogin = findViewById(R.id.botonLogin);

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(v.getContext(),Registro.class);
                startActivity(register);
            }
        });
    }
    public void openDialog(){

        LoginDialog ld = new LoginDialog();
        ld.show(getSupportFragmentManager(),"login dialog");
    }
}