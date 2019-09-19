package chantiri.garcia.sendmeal;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class home extends AppCompatActivity {

    private Toolbar mi_Toolbar;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.items_act2, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuOpt1:
                Log.i("ActionBar", "Nuevo!");
                return true;
            case R.id.mnuOpt2:
                Log.i("ActionBar", "Buscar!");
                ;
                return true;
            case R.id.mnuOpt5:
                Log.i("ActionBar", "Settings!");
                ;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
