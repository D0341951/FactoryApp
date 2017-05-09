package com.example.user.factoryapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.*;
/**
 * Created by user on 2017/5/6.
 */

public class BR_receiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager myConnectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = myConnectivityManager.getActiveNetworkInfo();

        if(info!=null && info.isConnected()) {

            Toast.makeText(context, "已連線至網路", Toast.LENGTH_SHORT).show();
        }
        else if(info==null) {

            Toast.makeText(context, "無法連線至網路", Toast.LENGTH_SHORT).show();
        }
    }
}

