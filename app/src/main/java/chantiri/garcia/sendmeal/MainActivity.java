package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText Nombre, Contraseña, ReContraseña, Email, NroTarjeta, CodTarjeta, MMAATarjeta, CTAalias, CTAcbu;
    private Switch SwVend;
    private LinearLayout LayCuenta;
    private Button Registrar;
    private CheckBox AceptaTerminos;
    private RadioButton BtnBase, BtnFull, BtnPremiun;
    private SeekBar SeekCreditoInicial;
    private TextView CreditoInicial;
    private RadioGroup tipoCuenta;
    private String emailPattern;
    public Integer montoBase, montoPremium, montoFull, inicioCredito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //elementos del usuario
        Nombre = (EditText) findViewById(R.id.regNombre);
        Contraseña = (EditText) findViewById(R.id.regClave);
        ReContraseña = (EditText) findViewById(R.id.regClave2);
        Email = (EditText) findViewById(R.id.regMail);

        //elementos vendedor
        CTAalias = (EditText) findViewById(R.id.ctaAlias);
        CTAcbu = (EditText) findViewById(R.id.ctaCBU);

        //elementos cuenta usuario
        LayCuenta = (LinearLayout) findViewById(R.id.layoutCuenta);
        NroTarjeta = (EditText) findViewById(R.id.regNro);
        CodTarjeta = (EditText) findViewById(R.id.regDigito);
        MMAATarjeta = (EditText) findViewById(R.id.regVto);

        AceptaTerminos = (CheckBox) findViewById(R.id.aceptaCondiciones);
        Registrar = (Button) findViewById(R.id.btnRegistrar);

        //elemento para validar el email
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        //elementos para la cuenta
        montoBase = 100;
        montoPremium = 250;
        montoFull = 500;
        inicioCredito = 0;

        BtnBase = (RadioButton) findViewById(R.id.optBase);
        BtnFull = (RadioButton) findViewById(R.id.optFull);
        BtnPremiun = (RadioButton) findViewById(R.id.optPremium);
        tipoCuenta = (RadioGroup) findViewById(R.id.tipoCuentaGrp);


        SeekCreditoInicial = (SeekBar) findViewById(R.id.regCredito);
        CreditoInicial = (TextView) findViewById(R.id.txtCredInicial);

        // Get the progress value of the SeekBar
        // using setOnSeekBarChangeListener() method
        SeekCreditoInicial.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // When the progress value has changed
            @Override
            public void onProgressChanged(
                    SeekBar seekBar,
                    int progress,

                    boolean fromUser) {

                // increment 1 in progress and
                // increase the textsize
                // with the value of progress

                //Toast.makeText(getApplicationContext(),String.valueOf(progress + 1),Toast.LENGTH_LONG).show();

                CreditoInicial.setText(String.valueOf(progress++));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                // This method will automatically
                // called when the user touches the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                // This method will automatically
                // called when the user
                // stops touching the SeekBar
            }
        });


    }


    public void seleccionTipoCuenta(View v) {

        switch (tipoCuenta.getCheckedRadioButtonId()) {
            case R.id.optBase:

                SeekCreditoInicial.setMin(100);
                SeekCreditoInicial.setProgress(0);
                Toast.makeText(this, "BASE", Toast.LENGTH_LONG).show();
                CreditoInicial.setText(montoBase.toString());
                inicioCredito = montoBase;
                break;

            case R.id.optPremium:

                SeekCreditoInicial.setMin(250);
                SeekCreditoInicial.setProgress(0);
                Toast.makeText(this, "PREMIUN", Toast.LENGTH_LONG).show();
                CreditoInicial.setText(montoPremium.toString());
                inicioCredito = montoPremium;
                break;

            case R.id.optFull:
                SeekCreditoInicial.setMin(500);
                SeekCreditoInicial.setProgress(0);
                Toast.makeText(this, "FULL", Toast.LENGTH_LONG).show();
                CreditoInicial.setText(montoFull.toString());
                inicioCredito = montoFull;
                break;

        }

    }

    public void Vendedor(View v) {
        SwVend = (Switch) findViewById(R.id.optEsVendedor);

        if (SwVend.isChecked()) {
            LayCuenta.setVisibility(View.VISIBLE);

        } else {
            LayCuenta.setVisibility(View.GONE);

        }

    }

    public void AceptaTerminos(View v) {
        if (AceptaTerminos.isChecked()) {
            Registrar.setEnabled(true);
        } else {
            Registrar.setEnabled(false);
        }
    }


    public void enviar(View v) {
        if (Nombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo Nombre vacio", Toast.LENGTH_LONG).show();
        } else {
            if (Contraseña.getText().toString().isEmpty()) {
                Toast.makeText(this, "Campo Contraseña vacio", Toast.LENGTH_LONG).show();
            } else {
                if (!(Contraseña.getText().toString().equalsIgnoreCase(ReContraseña.getText().toString()))) {
                    Toast.makeText(this, "Verifique validacion de contraseña", Toast.LENGTH_LONG).show();
                } else {
                    if (Email.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Campo E-Mail vacio", Toast.LENGTH_LONG).show();
                    } else {
                        if (Email.getText().toString().trim().matches(emailPattern)) {
                            Toast.makeText(this, "Verifique correo", Toast.LENGTH_LONG).show();
                        } else if (SwVend.isChecked()) {
                            if (CTAcbu.toString().isEmpty()) {
                                Toast.makeText(this, "Verifique CtaCBU", Toast.LENGTH_LONG).show();
                            } else {
                                if (CTAalias.toString().isEmpty()) {
                                    Toast.makeText(this, "Verifique CtaAlias", Toast.LENGTH_LONG).show();
                                }
                            }
                        } else {
                            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        }
    }
}




