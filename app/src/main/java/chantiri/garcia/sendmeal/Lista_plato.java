package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class Lista_plato extends AppCompatActivity {

    private RecyclerView rvplato;
    private LinearLayoutManager rlm;
    private Adaptador_lista_plato adapter;

    private Toolbar mi_Toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_plato);

        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);

      rvplato = (RecyclerView) findViewById(R.id.rv_platos);

      rlm = new LinearLayoutManager(this);
      rvplato.setLayoutManager(rlm);
      adapter = new Adaptador_lista_plato(Global.listaPlatos);
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
