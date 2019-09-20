package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;


public class home extends AppCompatActivity {

    private Toolbar mi_Toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.items_act2, menu);
        return true;
    }

}
