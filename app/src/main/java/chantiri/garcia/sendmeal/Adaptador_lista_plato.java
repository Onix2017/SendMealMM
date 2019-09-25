package chantiri.garcia.sendmeal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador_lista_plato extends RecyclerView.Adapter<PlatoViewHolder> {

    private ArrayList<Plato> data;

    public Adaptador_lista_plato(ArrayList<Plato> data) {

        this.data = data;
    }

    @Override
    public PlatoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlatoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_plato, parent, false));
    }

    @Override
    public void onBindViewHolder(PlatoViewHolder holder, int position) {
        Plato plato = data.get(position);
        holder.imgPlato.setImageResource(plato.getId_plato());
        holder.tituto_plato.setText(plato.getTituto_plato());
        holder.precio_plato.setText(plato.getPrecio_plato().toString());
    }

    @Override
    public int getItemCount() {

        return data.size();
    }


}
