package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Lista_plato extends AppCompatActivity {

    private RecyclerView rvplato;
    private RecyclerView.LayoutManager rlm;
    private RecyclerView.LayoutManager adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_plato);



     /* rvplato = (RecyclerView) findViewById(R.id.cv);
      rvplato.setHasFixedSize(true);
      LinearLayoutManager llm = new LinearLayoutManager(this);
      llm.setOrientation(LinearLayoutManager.VERTICAL);
      rvplato.setLayoutManager(llm);
      */
      rlm = new LinearLayoutManager(this);
      rvplato.setLayoutManager(rlm);
      adapter = new Adaptador_lista_plato(dataSet());
      rvplato.setAdapter(adapter);
    }
    private ArrayList<Plato> dataSet() {
        ArrayList<Plato> data = new ArrayList<>();
        data.add(new Plato(1, "Imagine Dragons","fgdg",12.90,12));
        data.add(new Plato(1, "Imagine Dragons","fgdg",12.90,12));
        data.add(new Plato(1, "Imagine Dragons","fgdg",12.90,12));

        return data;
    }

}
