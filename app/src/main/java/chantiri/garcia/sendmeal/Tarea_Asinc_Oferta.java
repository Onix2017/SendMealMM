package chantiri.garcia.sendmeal;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class Tarea_Asinc_Oferta extends AsyncTask<Context,Integer,Context>{


    @Override
    protected Context doInBackground(Context... contexts) {
        tareaLarga();
        return null;
    }

    protected  void tareaLarga()
    {
        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) {}
    }



    protected void onPostExecute(Context result){
        BroadcastReceiver br = new Broadcast_Oferta();
        Intent filtro = new Intent();
        filtro.setAction(Broadcast_Oferta.EVENTO);
        result.sendBroadcast(filtro);






    }

}
