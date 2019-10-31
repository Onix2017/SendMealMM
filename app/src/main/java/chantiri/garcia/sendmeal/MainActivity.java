package chantiri.garcia.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;


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
    private Toolbar mi_Toolbar;

    public Integer montoBase, montoPremium, montoFull, inicioCredito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mi_Toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(mi_Toolbar);


            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
                CharSequence name= getString(R.string.nombre_canal);
                String description= getString(R.string.descripcion_canal);
                int importance= NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel= new NotificationChannel("01", name, importance);
                channel.setDescription(description);
                NotificationManager notificationManager=getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }




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

        SwVend = (Switch) findViewById(R.id.optEsVendedor);

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

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_volver,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        // Toast.makeText(this, "Opcion Registrarse", Toast.LENGTH_LONG).show();
        //Intent i1 = new Intent(this, home.class);
        //startActivity(i1);
        this.finish();
        return true;
    }

    public void seleccionTipoCuenta(View v) {

        switch (tipoCuenta.getCheckedRadioButtonId()) {
            case R.id.optBase:

                SeekCreditoInicial.setMin(100);
                SeekCreditoInicial.setProgress(0);
               // Toast.makeText(this, "BASE", Toast.LENGTH_LONG).show();
                CreditoInicial.setText(montoBase.toString());
                inicioCredito = montoBase;
                break;

            case R.id.optPremium:

                SeekCreditoInicial.setMin(250);
                SeekCreditoInicial.setProgress(0);
               // Toast.makeText(this, "PREMIUN", Toast.LENGTH_LONG).show();
                CreditoInicial.setText(montoPremium.toString());
                inicioCredito = montoPremium;
                break;

            case R.id.optFull:
                SeekCreditoInicial.setMin(500);
                SeekCreditoInicial.setProgress(0);
                //Toast.makeText(this, "FULL", Toast.LENGTH_LONG).show();
                CreditoInicial.setText(montoFull.toString());
                inicioCredito = montoFull;
                break;

        }

    }

    public void Vendedor(View v) {

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


    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    private boolean validarFechaTarg(String fecha) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(fecha).matches();
    }

    private boolean CompararFechaTarj(String fecha)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        Date date = new Date();

        String fechaActual = dateFormat.format(date);

        //Toast.makeText(this, fecha, Toast.LENGTH_LONG).show();
        int añoA = Integer.parseInt(fechaActual.substring(8,10));
        int mesA = Integer.parseInt(fechaActual.substring(3,5));
        int año = Integer.parseInt(fecha.substring(3,5));
        int mes = Integer.parseInt(fecha.substring(0,2));
        int difM = mes-mesA;
        int difA = año - añoA;

        if ((difA == 0) && (difM > 2))
        {
            return  true;
        }
        else
        {
            if (difA > 1)
            {
                return true;
            }
            else
                {
                    if (((12-mesA) > 2) && ((mes-mesA) > -9))
                    {
                        return true;
                    }
                }
        }
        return false;
    }

    public void enviar(View v)
    {
        if (Nombre.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Campo Nombre vacio", Toast.LENGTH_LONG).show();
            return;
        }

        if (Contraseña.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo Contraseña vacio", Toast.LENGTH_LONG).show();
            return;
        }

        if (!(Contraseña.getText().toString().equalsIgnoreCase(ReContraseña.getText().toString())))
        {
            Toast.makeText(this, "Verifique validacion de contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        if (Email.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Campo E-Mail vacio", Toast.LENGTH_LONG).show();
            return;
        }

        if (!validarEmail(Email.getText().toString()))
        {
            Toast.makeText(this, "Verifique correo", Toast.LENGTH_LONG).show();
            return;
        }

        if (NroTarjeta.getText().toString().isEmpty() || CodTarjeta.getText().toString().isEmpty() || MMAATarjeta.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Verificar datos Tarjeta de Crédito", Toast.LENGTH_LONG).show();
            return;
        }

        if (!MMAATarjeta.getText().toString().matches("\\d{2}/\\d{2}") & (CompararFechaTarj(MMAATarjeta.getText().toString())))
        {
            Toast.makeText(this, "Verificar fecha Tarjeta de Crédito", Toast.LENGTH_LONG).show();
            return;
        }

        if (SwVend.isChecked())
        {
            if (CTAcbu.toString().isEmpty())
            {
                Toast.makeText(this, "Verifique CBU", Toast.LENGTH_LONG).show();
                return;
            }

            if (CTAalias.toString().isEmpty())
            {
                Toast.makeText(this, "Verifique Alias", Toast.LENGTH_LONG).show();
                return;
            }
        }

        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
    }


}







