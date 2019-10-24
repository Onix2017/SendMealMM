package chantiri.garcia.sendmeal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adaptador_lista_plato extends RecyclerView.Adapter<Adaptador_lista_plato.PlatoViewHolder> {

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
        holder.imgPlato.setImageResource(R.drawable.ic_restaurant_black_24dp);
        holder.tituto_plato.setText(plato.getTituto_plato()+"..");
        holder.precio_plato.setText(plato.getPrecio_plato().toString());
        holder.id_plato.setText(plato.id_plato.toString());

        //set Botones CardView
        holder.setOnClickListener();

    }

    @Override
    public int getItemCount() {

        return data.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public static class PlatoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        // context
        Context context;
        ImageView imgPlato;
        TextView tituto_plato;
        TextView precio_plato;
        TextView id_plato;

        Button editar_plato;
        Button eliminar_plato;
        Button oferta_plato;

        public PlatoViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();

            cv = (CardView)itemView.findViewById(R.id.cv);
            imgPlato = (ImageView) itemView.findViewById(R.id.foto_plato);
            tituto_plato = (TextView) itemView.findViewById(R.id.titulo_plato);
            precio_plato = (TextView) itemView.findViewById(R.id.precio_plato);
            id_plato = (TextView) itemView.findViewById(R.id.id_plato);

            editar_plato = (Button) itemView.findViewById(R.id.btnEditar);
            eliminar_plato = (Button) itemView.findViewById(R.id.btnElimnar);
            oferta_plato = (Button) itemView.findViewById(R.id.btnOferta);
        }
       public void setOnClickListener(){
           editar_plato.setOnClickListener(this);
           eliminar_plato.setOnClickListener(this);
           oferta_plato.setOnClickListener(this);

       }


        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnEditar:

                   Intent i3 = new Intent(context, CrearItem.class);
                   i3.putExtra("Extra_id_Plato",id_plato.getText());
                   ((Activity)context).startActivity(i3);
                   break;

                case R.id.btnElimnar:
                   this.eliminar(id_plato.getText().toString());
                   break;

                case R.id.btnOferta:
                    Tarea_Asinc_Oferta miTarea = new Tarea_Asinc_Oferta();
                    miTarea.execute(context, context,context);


                    BroadcastReceiver b = new Broadcast_Oferta();
                    Intent destino = new Intent(context, CrearItem.class);
                    b.onReceive(context,destino);
                    break;
            }
        }
        public void eliminar(final String idPlato){
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(context);
            dialogo1.setTitle("Importante");
            dialogo1.setMessage("¿Desea eliminar el Plato?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) { aceptar(idPlato);
                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    cancelar();
                }
            });
            dialogo1.show();
        }

        public void aceptar(String idPlato) {
            Global.listaPlatos.remove(buscarPosPlato(idPlato));
            ((Activity) context).recreate();
            }


        public void cancelar() {
        }

        public int buscarPosPlato (String idPlatoRecup){
            int i = 0;
            Plato plato = Global.listaPlatos.get(i);
            int cantPlato = Global.listaPlatos.size()-1;
            while (i< cantPlato){
                if(plato.id_plato.toString() == idPlatoRecup){
                    return i;
                }else{
                    i++;
                    plato= Global.listaPlatos.get(i);
                }
            }

            return i;
        }

      }
}

