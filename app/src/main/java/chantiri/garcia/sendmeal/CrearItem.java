package chantiri.garcia.sendmeal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import chantiri.garcia.sendmeal.Dao.PlatoRepository;

public class CrearItem extends AppCompatActivity {

    private EditText idPlato, NombrePlato, DescPlato, precioPlato, CaloriaPlato;
    private Button BtnGPlato;
    private String recupId_plato, recupId_plato1;
    private Toolbar mi_Toolbar;

    private Plato PlatoActual;

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
        if (recupId_plato != null)
        {

           cargarItemPlato(recupId_plato);
        }

        recupId_plato1 = this.getIntent().getStringExtra("Extra_id_Plato1");
        if(recupId_plato1 != null) {
            Log.d("Id Plato:",Adaptador_lista_plato.ID_PLATO_OFERTA);
            cargarItemPlatoOferta(recupId_plato1);
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

                            if(recupId_plato != null)
                            {
                                int i = buscarPosPlato(recupId_plato);

                                Global.listaPlatos.get(i).setTituto_plato(NombrePlato.getText().toString());
                                Global.listaPlatos.get(i).setDescripcion_plato(DescPlato.getText().toString());
                                Global.listaPlatos.get(i).setPrecio_plato(preciop);
                                Global.listaPlatos.get(i).setCalorias_plato(caloriop);



                                Intent i2 = new Intent(this, Lista_plato.class);
                                startActivity(i2);
                                finish();

                                //Global.listaPlatos.set(i,pNew);
                            }else{
                                if(recupId_plato1 != null)
                                {
                                    Intent i2 = new Intent(this, Lista_plato.class);
                                    startActivity(i2);
                                    finish();
                                }else{

                                        Plato nuevoP = new Plato(idp, NombrePlato.getText().toString(), DescPlato.getText().toString(), preciop, caloriop);

                                        Global.listaPlatos.add(nuevoP);

                                        //CREA EL PLATO EN EL ARCHIVO LAB-DAM.JSON
                                        PlatoRepository.getInstance().crearPlato(nuevoP,miHandler);
                                }
                                }

                            finish();
                        }
                    }
                }
            }

        }

    }

    Handler miHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(Message msg) {
            Log.d("APP_2","Vuelve al handler"+msg.arg1);

        /*    switch (msg.arg1 ){
                case PlatoRepository._ALTA_OBRA:
                case PlatoRepository._UPDATE_OBRA:
                    Intent i = new Intent(PlatoActivity.this,PlatoListActivity.class);
                    startActivity(i);
                    break;
            }*/
        }
    };

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

        Plato plato1 = PlatoRepository.getInstance().getListaPlatos().get(i);

        DescPlato.setText(plato1.descripcion_plato);
        precioPlato.setText(plato1.precio_plato.toString());
        CaloriaPlato.setText(plato1.calorias_plato.toString());
        idPlato.setText(plato1.id_plato.toString());
        NombrePlato.setText(plato1.tituto_plato);
        idPlato.setEnabled(false);
    }

    public void cargarItemPlatoOferta (String idPlatoRecup){

        int i = buscarPosPlato(idPlatoRecup);
        Plato plato = Global.listaPlatos.get(i);

        DescPlato.setText(plato.descripcion_plato);
        precioPlato.setText(plato.precio_plato.toString());
        CaloriaPlato.setText(plato.calorias_plato.toString());
        idPlato.setText(plato.id_plato.toString());
        NombrePlato.setText(plato.tituto_plato);

        idPlato.setEnabled(false);
        precioPlato.setEnabled(false);
        CaloriaPlato.setEnabled(false);
        NombrePlato.setEnabled(false);
        DescPlato.setEnabled(false);

    }

}
