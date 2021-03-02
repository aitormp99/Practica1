package com.example.primerapractica;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerapractica.entidades.Libro;

import java.util.List;

public class LibroRecyclerAdapter extends RecyclerView.Adapter<LibroRecyclerAdapter.LibroViewHolder> {
    private List<Libro> listaLibro;

    public LibroRecyclerAdapter(List<Libro> listaLibro) {
        this.listaLibro = listaLibro;
    }


    @Override
    public LibroViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_libro_recycler, parent, false);

         */
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LibroRecyclerAdapter.LibroViewHolder holder, int position) {
        holder.campoNombre.setText(listaLibro.get(position).getNombre());
        holder.campoAutor.setText(listaLibro.get(position).getAutor());
        holder.campoFecha.setText(listaLibro.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        Log.v(LibroRecyclerAdapter.class.getSimpleName(),""+listaLibro.size());
        return listaLibro.size();
    }

    public class LibroViewHolder extends RecyclerView.ViewHolder{

        public AppCompatTextView campoNombre;
        public AppCompatTextView campoAutor;
        public AppCompatTextView campoFecha;

        public LibroViewHolder(View view) {

            super(view);
            /*
            campoNombre =  view.findViewById(R.id.textViewNombre);
            campoAutor =  view.findViewById(R.id.textViewAutor);
            campoFecha =  view.findViewById(R.id.textViewLanzamiento);
            */

        }
    }
}


