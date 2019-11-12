package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import chantiri.garcia.sendmeal.Dao.PlatoRepository;

public class Lista_plato extends AppCompatActivity {

    private RecyclerView rvplato;
    private LinearLayoutManager rlm;
    private Adaptador_lista_plato adapter;
    private ArrayList<Plato> lista_plato;

    private Toolbar mi_Toolbar;
    private String nombrePlato;
    private String precioMin, precioMax;
    private String tilde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_plato);


        Handler miHandler = new Handler(Looper.myLooper());


        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);

        rvplato = (RecyclerView) findViewById(R.id.rv_platos);

         rlm = new LinearLayoutManager(this);
         rvplato.setLayoutManager(rlm);

        tilde = this.getIntent().getStringExtra("tilde");


      //  Toast.makeText(this,pMin.toString(), Toast.LENGTH_LONG).show();

        if(tilde.equals("2"))
        {
            nombrePlato = this.getIntent().getStringExtra("nombrePlato");
            //     precioMin = this.getIntent().getStringExtra("precioMin");
            //   precioMax = this.getIntent().getStringExtra("precioMax");
            //   Log.d("valor minimo",precioMin);
            //   Double pMin = Double.parseDouble(precioMin);
            //    Double pMax = Double.parseDouble(precioMax);
            lista_plato = PlatoRepository.getInstance().filtrarPlatos(nombrePlato,0,45,miHandler);
        }else{
            PlatoRepository.getInstance().listarPlato(miHandler);
            lista_plato = PlatoRepository.getInstance().getListaPlatos();
        }

       // lista_plato = PlatoRepository.getInstance().filtrarPlatos(nombrePlato,0,45,miHandler);

       //  adapter = new Adaptador_lista_plato(Global.listaPlatos);


        adapter = new Adaptador_lista_plato(lista_plato,tilde);
         rvplato.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_volver_lista,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        // Toast.makeText(this, "Opcion Registrarse", Toast.LENGTH_LONG).show();
        Intent i1 = new Intent(this, home.class);
        startActivity(i1);
        return true;
    }


}
