package chantiri.garcia.sendmeal;


import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class Tarea_Asinc_Oferta extends AsyncTask<Integer,Integer,Integer>{


    @Override
    protected Integer doInBackground(Integer... integers) {
        tareaLarga();
        return null;
    }

    protected  void tareaLarga()
    {
        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) {}
    }
    protected int onPostExecute(int result){
        Broadcast_Oferta o = new Broadcast_Oferta();
        return 1;
    }


}
