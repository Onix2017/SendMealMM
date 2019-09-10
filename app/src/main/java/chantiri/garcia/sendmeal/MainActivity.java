package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText Nombre, Contraseña, ReContraseña,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (EditText) findViewById(R.id.regNombre);
        Contraseña = (EditText) findViewById(R.id.regClave);
        ReContraseña = (EditText) findViewById(R.id.editText2);
        Email = (EditText) findViewById(R.id.regMail);
    }

    public void enviar(View v){
        if(Nombre.getText().toString().isEmpty()) {
            Toast.makeText(this,"Campo Nombre vacio",Toast.LENGTH_LONG).show();
        }else {
            if(Contraseña.getText().toString().isEmpty()) {
                Toast.makeText(this,"Campo Contraseña vacio",Toast.LENGTH_LONG).show();
            }else {
                if(ReContraseña.getText().toString().isEmpty()){
                    Toast.makeText(this,"Campo Nombre vacio",Toast.LENGTH_LONG).show();
                }else {
                    if(Email.getText().toString().isEmpty()) {
                        Toast.makeText(this,"Campo Nombre vacio",Toast.LENGTH_LONG).show();
                    }else {
                        if(ReContraseña.getText().toString()!=Contraseña.getText().toString()) {
                            Toast.makeText(this,"Verifique validacion contraseña",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        }

        }

        }


