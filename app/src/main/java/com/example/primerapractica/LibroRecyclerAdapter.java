package com.example.primerapractica;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerapractica.entidades.Libro;

import java.util.ArrayList;
import java.util.List;

public class LibroRecyclerAdapter extends RecyclerView.Adapter<LibroRecyclerAdapter.LibroViewHolder> {

    private ArrayList<Libro> listaLibro;

    public LibroRecyclerAdapter(ArrayList<Libro> listaLibro) {

        this.listaLibro = listaLibro;

    }


    @Override
    public LibroViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_libros,null,false);
        return new LibroViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull LibroRecyclerAdapter.LibroViewHolder holder, int position) {

        holder.nombre.setText(listaLibro.get(position).getNombre());
        holder.autor.setText(listaLibro.get(position).getAutor());
        holder.fecha.setText(listaLibro.get(position).getFecha());

    }

    @Override
    public int getItemCount() {

        return listaLibro.size();

    }

    public class LibroViewHolder extends RecyclerView.ViewHolder{

        public TextView nombre, autor, fecha;

        public LibroViewHolder(@NonNull  View itemView) {

            super(itemView);

            nombre =  itemView.findViewById(R.id.textNombre);
            autor =  itemView.findViewById(R.id.textAutor);
            fecha =  itemView.findViewById(R.id.textLanzamiento);


        }
    }
}


