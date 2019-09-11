package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText Nombre, Contraseña, ReContraseña,Email, NroTarjeta,CodTarjeta,MMAATarjeta;
    private Switch SwVend;
    private LinearLayout LayCuenta;
    private CheckBox AceptaTerminos;
    private Button Registrar;
    private RadioButton BtnBase, BtnFull, BtnPremiun;
    private SeekBar SeekCreditoInicial;
    private TextView CreditoInicial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (EditText) findViewById(R.id.regNombre);
        Contraseña = (EditText) findViewById(R.id.regClave);
        ReContraseña = (EditText) findViewById(R.id.regClave2);
        Email = (EditText) findViewById(R.id.regMail);
        LayCuenta = (LinearLayout) findViewById(R.id.layoutCuenta);
        NroTarjeta = (EditText) findViewById(R.id.regNro);
        CodTarjeta = (EditText) findViewById(R.id.regDigito);
        MMAATarjeta = (EditText) findViewById(R.id.regVto);
        AceptaTerminos = (CheckBox) findViewById(R.id.aceptaCondiciones);
        Registrar = (Button) findViewById(R.id.btnRegistrar);
        BtnBase = (RadioButton) findViewById(R.id.optBase);
        BtnFull = (RadioButton) findViewById(R.id.optFull);
        BtnPremiun = (RadioButton) findViewById(R.id.optPremium);


        SeekCreditoInicial = (SeekBar) findViewById(R.id.regCredito);
        CreditoInicial = (TextView) findViewById(R.id.txtCredInicial);
  //      Text_message = (TextView)findViewById(R.id.message_id);
  //      seekbar = (SeekBar)findViewById(R.id.seekbar);

        // Get the progress value of the SeekBar
        // using setOnSeekBarChangeListener() method
        SeekCreditoInicial
                .setOnSeekBarChangeListener(
                        new SeekBar
                                .OnSeekBarChangeListener() {

                            // When the progress value has changed
                            @Override
                            public void onProgressChanged(
                                    SeekBar seekBar,
                                    int progress,

                                    boolean fromUser)
                            {

                                // increment 1 in progress and
                                // increase the textsize
                                // with the value of progress

                                CreditoInicial.setText(String.valueOf(progress + 1));
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar)
                            {

                                // This method will automatically
                                // called when the user touches the SeekBar
                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar)
                            {

                                // This method will automatically
                                // called when the user
                                // stops touching the SeekBar
                            }
                        });


    }


    public void Vendedor(View v){
        SwVend = (Switch) findViewById(R.id.optEsVendedor);

        if(SwVend.isChecked())
        {
            LayCuenta.setVisibility(View.VISIBLE);
          //  Toast.makeText(this,"Encendido",Toast.LENGTH_LONG).show();
        }else
        {
            LayCuenta.setVisibility(View.GONE);
            //Toast.makeText(this,"Apagado",Toast.LENGTH_LONG).show();
        }

    }
    public void AceptaTerminos(View v){
        if(AceptaTerminos.isChecked()) {
            Registrar.setEnabled(true);
        }else {
            Registrar.setEnabled(false);
        }
    }


    public void enviar(View v){
        if(Nombre.getText().toString().isEmpty()) {
            Toast.makeText(this,"Campo Nombre vacio",Toast.LENGTH_LONG).show();
        }else {
            if(Contraseña.getText().toString().isEmpty()) {
                Toast.makeText(this,"Campo Contraseña vacio",Toast.LENGTH_LONG).show();
            }else {
                if(ReContraseña.getText().toString().isEmpty()){
                    Toast.makeText(this,"Campo validar contraseña vacio",Toast.LENGTH_LONG).show();
                }else {
                    if(Email.getText().toString().isEmpty()) {
                        Toast.makeText(this,"Campo E-Mail vacio",Toast.LENGTH_LONG).show();
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


