package chantiri.garcia.sendmeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CrearItem extends AppCompatActivity {

    private Toolbar mi_Toolbar;


    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearitemp);

        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);
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
    }
}
