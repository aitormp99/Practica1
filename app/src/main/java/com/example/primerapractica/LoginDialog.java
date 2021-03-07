package com.example.primerapractica;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.primerapractica.utilidades.Utilidades;

public class LoginDialog extends AppCompatDialogFragment {
    private EditText usuario,contrasena;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialogo_inicio,null);

        builder.setView(view)
                //al pulsar cancelar cierra el dialogo
                .setNegativeButton(R.string.botonCancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton(R.string.botonAceptar, new DialogInterface.OnClickListener() {
            @Override

            //si el usuario y contraseña son correctos abre la actividad MenuLibro
            public void onClick(DialogInterface dialog, int which) {

                if (loginUsuario() == true){
                    Intent lista = new Intent(getContext(), MenuLibro.class);
                    startActivity(lista);
                }else{
                    Toast.makeText(getContext(),R.string.ErrorLogin,Toast.LENGTH_LONG).show();
                }



            }
        });
        usuario = view.findViewById(R.id.usuario);
        contrasena = view.findViewById(R.id.contrasena);


        return builder.create();

    }

    //metodo el cual comprueba si el usuario o la contraseña coinciden
    public Boolean loginUsuario(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(),"bd_usuarios",null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametros ={usuario.getText().toString(),contrasena.getText().toString()};

        Cursor cursor =  db.rawQuery("Select * from "+ Utilidades.TABLA_USUARIO+" where "+Utilidades.CAMPO_USUARIO+" =? and "+Utilidades.CAMPO_CONTRASENA+" = ?",parametros);

        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
}