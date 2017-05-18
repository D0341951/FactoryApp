package com.example.user.factoryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.WindowManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final int PageMain = 0;
    int currentPage;
    public static final String BROADCAST_ACTION = "android.intent.action.MAIN";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        pagemain();
    }

    private void pagemain() {

        Intent intent = new Intent(BROADCAST_ACTION);
        sendBroadcast(intent);

        currentPage = PageMain;
        setContentView(R.layout.activity_main);
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
        Button agent = (Button)findViewById(R.id.agent);
        agent.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent agt = new Intent();
                agt.setClass(MainActivity.this, com.example.user.factoryapp.agent2.class);
                startActivity(agt);
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK)) {   //確定按下退出鍵

            ConfirmExit(); //呼叫ConfirmExit()函數

            return true;

        }

        return super.onKeyDown(keyCode, event);

    }

    public void ConfirmExit(){

        AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this).setCancelable(false); //創建訊息方塊

        ad.setTitle("離開");

        ad.setMessage("確定要離開?");

        ad.setPositiveButton("是", new DialogInterface.OnClickListener() { //按"是",則退出應用程式

            public void onClick(DialogInterface dialog, int i) {

                MainActivity.this.finish();//關閉activity

            }

        });

        ad.setNegativeButton("否",new DialogInterface.OnClickListener() { //按"否",則不執行任何操作

            public void onClick(DialogInterface dialog, int i) {

            }

        });

        ad.show();//顯示訊息視窗

    }
}
