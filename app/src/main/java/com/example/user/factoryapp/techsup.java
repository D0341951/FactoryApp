package com.example.user.factoryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;

public class techsup extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techsup);

        Button btn_pdf1 = (Button) findViewById(R.id.btn_pdf1);
        btn_pdf1.setOnClickListener(pdf1);
        Button btn_pdf2 = (Button) findViewById(R.id.btn_pdf2);
        btn_pdf2.setOnClickListener(pdf2);
        Button btn_pdf3 = (Button) findViewById(R.id.btn_pdf3);
        btn_pdf3.setOnClickListener(pdf3);
        Button btn_pdf4 = (Button) findViewById(R.id.btn_pdf4);
        btn_pdf4.setOnClickListener(pdf4);
        Button btn_pdf5 = (Button) findViewById(R.id.btn_pdf5);
        btn_pdf5.setOnClickListener(pdf5);
    }

    View.OnClickListener pdf1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            DrillPDF thread1 = new DrillPDF(techsup.this);
            thread1.start();
        }
    };
    View.OnClickListener pdf2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            EXpowerPDF thread2 = new EXpowerPDF(techsup.this);
            thread2.start();
        }
    };
    View.OnClickListener pdf3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            TapPDF thread3 = new TapPDF(techsup.this);
            thread3.start();
        }
    };
    View.OnClickListener pdf4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            SpindlePDF thread4 = new SpindlePDF(techsup.this);
            thread4.start();
        }
    };
    View.OnClickListener pdf5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            ToolingPDF thread5 = new ToolingPDF(techsup.this);
            thread5.start();
        }
    };


    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(techsup.this, MainActivity.class);
            startActivity(intent);
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
