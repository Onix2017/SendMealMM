package chantiri.garcia.sendmeal;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Broadcast_Oferta extends BroadcastReceiver {
    public static final String EVENTO = "android.intent.EVENTO";

    @Override
    public void onReceive(Context context, Intent intent) {


     //   PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
     //           PendingIntent.FLAG_ONE_SHOT);

     //   Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Log.d("Id Plato:",Adaptador_lista_plato.ID_PLATO_OFERTA);
        Intent destino = new Intent(context,CrearItem.class);
        destino.putExtra("Extra_id_Plato1",Adaptador_lista_plato.ID_PLATO_OFERTA);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,destino,PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context,"01")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Su plato esta en oferta")
                .setContentText("Ver")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);




        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(99,notificationBuilder.build());

    }
}
