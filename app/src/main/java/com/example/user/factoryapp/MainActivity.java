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

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager myConnectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = myConnectivityManager.getActiveNetworkInfo();



        if(info!=null && info.isConnected()) {

            //info.isConnected();                         //是否連線
            //info.getTypeName();                         //網路連線名稱(wifi || mobile)
            //info.getState();                            //網路連線狀態
            //info.isAvailable();                         //網路是否可使用
            //info.isConnectedOrConnecting();             //網路是否已連接或連線中
            //info.isFailover();                          //網路是否故障
            //info.isRoaming();                          //網路是否在漫遊模式
            Button introd = (Button)findViewById(R.id.introd);
            introd.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intr = new Intent();
                    intr.setClass(MainActivity.this, introduction.class);
                    startActivity(intr);
                    finish();
                }
            });
            Button catalog = (Button)findViewById(R.id.catalog);
            catalog.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent cata = new Intent();
                    cata.setClass(MainActivity.this, catalog.class);
                    startActivity(cata);
                    finish();
                }
            });
            Button audio = (Button)findViewById(R.id.audio);
            audio.setOnClickListener(new Button.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent aud = new Intent();
                    aud.setClass(MainActivity.this, audio.class);
                    startActivity(aud);
                    finish();
                }
            });
            Button query = (Button)findViewById(R.id.query);
            query.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent que = new Intent();
                    que.setClass(MainActivity.this, query.class);
                    startActivity(que);
                    finish();
                }
            });
            Button feedback = (Button)findViewById(R.id.feed);
            feedback.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent fb = new Intent();
                    fb.setClass(MainActivity.this, feedback.class);
                    startActivity(fb);
                    finish();
                }
            });
        }
        else if(info==null) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setMessage("請開啟網路").setTitle("連線錯誤").setCancelable(false).setPositiveButton("ok", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {

                    //finish();
                }
            });

            dialog.show();
        }

    }


/*    public boolean onKeyDowm(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }*/
}
