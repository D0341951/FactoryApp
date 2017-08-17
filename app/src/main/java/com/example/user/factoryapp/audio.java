package com.example.user.factoryapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.NetworkInfo;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class audio extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE );
        //getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_audio);
        /*
        */
    }

   public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(audio.this, MainActivity.class);
            startActivity(intent);
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
