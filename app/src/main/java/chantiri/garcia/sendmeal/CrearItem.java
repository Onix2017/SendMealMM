package chantiri.garcia.sendmeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class CrearItem extends AppCompatActivity {

    private EditText idPlato, NombrePlato, DescPlato, precioPlato, CaloriaPlato;
    private Button BtnGPlato;

    private Toolbar mi_Toolbar;

    //private  Global GlobalPlato;// = (Global) this.getApplicationContext();

    @Override

    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearitemp);

        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);


        idPlato = (EditText) findViewById(R.id.etPlatoId);
        NombrePlato = (EditText) findViewById(R.id.etPlatoNombre);
        DescPlato = (EditText) findViewById(R.id.etPlatoDescripcion);
        precioPlato = (EditText) findViewById(R.id.etPlatoPrecio);
        CaloriaPlato = (EditText) findViewById(R.id.etPlatoCaloria);

        BtnGPlato = (Button) findViewById(R.id.btnGuardarPlato);

    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_volver_plato,menu);
        return super.onCreateOptionsMenu(menu);
    }

   public boolean onOptionsItemSelected(MenuItem item){
        // Toast.makeText(this, "Opcion Registrarse", Toast.LENGTH_LONG).show();
        Intent i1 = new Intent(this, home.class);
        startActivity(i1);
        return true;
    }


    public void GuardarPlato(View view) {

        Plato nuevoP = new Plato(Integer.parseInt(idPlato.toString()), NombrePlato.toString(), DescPlato.toString(), Double.parseDouble(precioPlato.toString()), Integer.parseInt(CaloriaPlato.toString()));

        Global.listaPlatos.add(nuevoP);


       // ArrayList<Plato> pp = GlobalPlato.getListaPlatos();

        Toast.makeText(this, String.valueOf(Global.listaPlatos.size()), Toast.LENGTH_LONG).show();
    }
}
