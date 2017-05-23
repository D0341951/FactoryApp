package com.example.user.factoryapp;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class techsup extends AppCompatActivity {

    final String msgOK = "下載完成";
    final String msgNOK = "下載失敗";
    final String fireurl = "http://pet.chumpower.com/downfile.php?id=D2016091300002_57d90f936a422_tw.pdf&type=down";
    final String Ldoubleurl = "http://pet.chumpower.com/downfile.php?id=D2016091299991_57daa60c883eb_tw.pdf&type=down";
    final String wideurl = "http://pet.chumpower.com/downfile.php?id=D2016091300003_57d90f9f15303_tw.pdf&type=down";
    final String Ldoublelargeurl = "http://pet.chumpower.com/downfile.php?id=D2016091299994_57daa64b00134_tw.pdf&type=down";
    final String oneurl = "http://pet.chumpower.com/downfile.php?id=D2016091300015_57d90fc3a237f_tw.pdf&type=down";

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

            download(fireurl, "鳳凰機.pdf");
        }
    };
    View.OnClickListener pdf2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            download(Ldoubleurl, "L雙軸延伸拉吹機.pdf");
        }
    };
    View.OnClickListener pdf3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            download(wideurl, "廣口機.pdf");
        }
    };
    View.OnClickListener pdf4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            download(Ldoublelargeurl, "L雙軸延伸拉吹機大容量瓶.pdf");
        }
    };
    View.OnClickListener pdf5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            download(oneurl, "一段式.pdf");
        }
    };

    public void download(String url, String filename) {

        try {

            File pdf = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath(), filename);
            FileOutputStream fos = new FileOutputStream(pdf);
            URL Url = new URL(url);
            URLConnection conn = Url.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            is.close();
            fos.close();
            Toast.makeText(techsup.this, msgOK, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {

            Toast.makeText(techsup.this, msgNOK, Toast.LENGTH_SHORT).show();
        }
    }

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
