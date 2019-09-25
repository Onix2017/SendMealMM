package chantiri.garcia.sendmeal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

    class PlatoViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        ImageView imgPlato;
        TextView tituto_plato;
        TextView precio_plato;

        public PlatoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            imgPlato = (ImageView) itemView.findViewById(R.id.foto_plato);
            tituto_plato = (TextView) itemView.findViewById(R.id.titulo_plato);
            precio_plato = (TextView) itemView.findViewById(R.id.precio_plato);
        }


    }

