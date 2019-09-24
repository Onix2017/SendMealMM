package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Lista_plato extends AppCompatActivity {

    private RecyclerView rvplato;
    private GridLayoutManager glm;
    private Adaptador_lista_plato adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_plato);

        rvplato = (RecyclerView) findViewById(R.id.rv_platos);

        glm = new GridLayoutManager(this, 2);
        rvplato.setLayoutManager(glm);
        adapter = new Adaptador_lista_plato(dataSet());
        Adaptador_lista_plato..setAdapter(adapter);
    }

}
