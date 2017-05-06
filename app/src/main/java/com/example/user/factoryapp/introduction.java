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
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class introduction extends AppCompatActivity {

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        back = (Button)findViewById(R.id.back1);
        back.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(introduction.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    /*public boolean onKeyDowm(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }*/
}
