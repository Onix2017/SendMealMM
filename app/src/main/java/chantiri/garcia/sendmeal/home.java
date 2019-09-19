package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import android.support.v7.widget.Toolbar;

public class home extends AppCompatActivity {

    private Toolbar mi_Toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);
    }
}
