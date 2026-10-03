package com.example.auditoriaprincipal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(
                        Context.CONNECTIVITY_SERVICE
                );

        NetworkInfo networkInfo =
                connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            Toast.makeText(
                    context,
                    "Red conectada",
                    Toast.LENGTH_SHORT
            ).show();

        } else {

            Toast.makeText(
                    context,
                    "Sin conexión a Internet",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}