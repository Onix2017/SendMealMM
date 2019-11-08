package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class busquedaPlato extends AppCompatActivity {
    Button buscarPlato;
    TextView precioMin, precioMax;
    TextView nombPlato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_plato);
        precioMax = (TextView) findViewById(R.id.precioMax);
        precioMin = (TextView) findViewById(R.id.precioMin);
        nombPlato = (TextView) findViewById(R.id.nombPlato);
        buscarPlato = (Button) findViewById(R.id.buscarPlato);


        buscarPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((precioMax.getText().toString() == null || precioMin.getText().toString() == null ) &&  (nombPlato.getText().toString() == null)){
                    Toast.makeText(busquedaPlato.this, "Ingrese Min y Max o nombre de plato", Toast.LENGTH_LONG).show();
                }
                else{

                  //  Toast.makeText(busquedaPlato.this, nombPlato.getText().toString(), Toast.LENGTH_LONG).show();

                Intent i = new Intent(busquedaPlato.this,Lista_plato.class);
                i.putExtra("precioMin", precioMin.getText());
                i.putExtra("precioMax",precioMax.getText());
                i.putExtra("nombrePlato",nombPlato.getText().toString());
                i.putExtra("tilde","2");
                startActivity(i);
                }
            }
        });
    }
}
