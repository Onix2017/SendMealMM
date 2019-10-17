package chantiri.garcia.sendmeal;

import android.app.Activity;
import android.content.Context;
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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class CrearItem extends AppCompatActivity {

    private EditText idPlato, NombrePlato, DescPlato, precioPlato, CaloriaPlato;
    private Button BtnGPlato;
    private String recupId_plato;
    private Toolbar mi_Toolbar;

    //private  Global GlobalPlato;// = (Global) this.getApplicationContext();

    @Override

    protected void onCreate(Bundle savedInstanceState) {

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


        recupId_plato = this.getIntent().getStringExtra("Extra_id_Plato");
        if (recupId_plato != null){
           cargarItemPlato(recupId_plato);
        }

        }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_volver_plato, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Toast.makeText(this, "Opcion Registrarse", Toast.LENGTH_LONG).show();

        this.finish();
        return true;
    }


    public void GuardarPlato(View view) {


        if (idPlato.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo ID vacio", Toast.LENGTH_LONG).show();
        } else {
            if (NombrePlato.getText().toString().isEmpty()) {
                Toast.makeText(this, "Campo Nombre vacio", Toast.LENGTH_LONG).show();
            } else {
                if (DescPlato.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Campo Descripcion vacio", Toast.LENGTH_LONG).show();
                } else {
                    if (precioPlato.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Campo Precio vacio", Toast.LENGTH_LONG).show();
                    } else {
                        if (CaloriaPlato.getText().toString().isEmpty()) {
                            Toast.makeText(this, "Campo Calorias vacio", Toast.LENGTH_LONG).show();
                        } else {
                            Integer idp = Integer.parseInt(idPlato.getText().toString());
                            Double preciop = Double.parseDouble(precioPlato.getText().toString());
                            Integer caloriop = Integer.parseInt(CaloriaPlato.getText().toString());

                            if(recupId_plato != null){
                                int i = buscarPosPlato(recupId_plato);
                                //Plato pNew = Global.listaPlatos.get(i);

                                Global.listaPlatos.get(i).setTituto_plato(NombrePlato.getText().toString());
                                Global.listaPlatos.get(i).setDescripcion_plato(DescPlato.getText().toString());
                                Global.listaPlatos.get(i).setPrecio_plato(preciop);
                                Global.listaPlatos.get(i).setCalorias_plato(caloriop);

                                Intent i2 = new Intent(this, Lista_plato.class);
                                startActivity(i2);
                                finish();

                                //Global.listaPlatos.set(i,pNew);
                            }else{

                            Plato nuevoP = new Plato(idp, NombrePlato.getText().toString(), DescPlato.getText().toString(), preciop, caloriop);

                            Global.listaPlatos.add(nuevoP);
                            }

                            finish();
                        }
                    }
                }
            }

        }

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

    public void cargarItemPlato (String idPlatoRecup){

        int i = buscarPosPlato(idPlatoRecup);
       Plato plato = Global.listaPlatos.get(i);

        DescPlato.setText(plato.descripcion_plato.toString());
        precioPlato.setText(plato.precio_plato.toString());
        CaloriaPlato.setText(plato.calorias_plato.toString());
        idPlato.setText(plato.id_plato.toString());
        NombrePlato.setText(plato.tituto_plato);
        idPlato.setEnabled(false);
    }



}
