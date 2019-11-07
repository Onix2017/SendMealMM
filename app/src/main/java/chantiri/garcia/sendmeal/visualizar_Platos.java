package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chantiri.garcia.sendmeal.Dao.PlatoRepository;

public class visualizar_Platos extends AppCompatActivity {
    Button btnCargarPlato, btnVolver;
    ListView lvPlatos;
    ArrayList<Plato> listaDataSet;
    ArrayAdapter<Plato> adapter;
    Plato currentPlato;
    int indiceCurrentPlato=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_platos);
        btnCargarPlato = (Button) findViewById(R.id.btnCargar);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnCargarPlato.setEnabled(false);
        lvPlatos = (ListView) findViewById(R.id.listaPlatos);

        Handler miHandler = new Handler(Looper.myLooper());


        lvPlatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                indiceCurrentPlato = position;
                currentPlato = adapter.getItem(position);
                btnCargarPlato.setEnabled(true);

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(visualizar_Platos.this, busquedaPlato.class);
                startActivity(i);
            }
        });

        btnCargarPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(visualizar_Platos.this, busquedaPlato.class);
                startActivity(i);
            }
        });


        PlatoRepository.getInstance().listarPlato(miHandler);

        listaDataSet = PlatoRepository.getInstance().filtrarPlatos("sdd",miHandler);
        //listaDataSet= PlatoRepository.getInstance().getListaPlatos();
        Toast.makeText(visualizar_Platos.this, listaDataSet.get(1).tituto_plato.toString(), Toast.LENGTH_LONG).show();


        adapter = new ArrayAdapter<>(visualizar_Platos.this, android.R.layout.simple_list_item_single_choice, listaDataSet);
        lvPlatos.setAdapter(adapter);

    }
}
