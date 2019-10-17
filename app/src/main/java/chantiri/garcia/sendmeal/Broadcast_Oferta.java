package chantiri.garcia.sendmeal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class Broadcast_Oferta extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_NEW_OUTGOING_CALL);

    }
}
