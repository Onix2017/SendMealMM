package chantiri.garcia.sendmeal;

import android.app.Application;

import java.util.ArrayList;

public class Global extends Application {

    private ArrayList<Plato> listaPlatos = new ArrayList<Plato>();

    public void AgregarPlatos(Plato p){

        listaPlatos.add(p);
        return;

    }

    public ArrayList<Plato> getListaPlatos(){
        return listaPlatos;
    }

}
