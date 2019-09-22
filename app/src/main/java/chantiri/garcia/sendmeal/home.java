package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class home extends AppCompatActivity {

    private Toolbar mi_Toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items_act2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.mnuOpt1:
               // Toast.makeText(this, "Opcion Registrarse", Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(this, TarjetaCredito.class);
                startActivity(i1);
                return true;
        }
        return true;
    }
}
