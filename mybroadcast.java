package com.example.brij.sunshine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Brij on 7/8/2017.
 */

public class mybroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

       check_error(context);
    }

    public static boolean check_error(Context context) {

        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=cm.getActiveNetworkInfo();

            if(networkInfo!=null)
            {
                if(networkInfo.getType()==cm.TYPE_MOBILE)
                {
                    Toast.makeText(context, "Mobile Internet", Toast.LENGTH_SHORT).show();
                    return true;
                }

                else if((networkInfo.getType()==cm.TYPE_WIFI))
                {
                    Toast.makeText(context, "Wifi Connection", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }

            else
            {
                Toast.makeText(context, "No connection", Toast.LENGTH_SHORT).show();
                return false;

            }
            return false;
    }
}
