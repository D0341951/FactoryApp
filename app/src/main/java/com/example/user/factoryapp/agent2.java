package com.example.user.factoryapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class agent2 extends AppCompatActivity {

    ImageView iv1, iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent2);

        iv1 = (ImageView)findViewById(R.id.iv1);
        iv2 = (ImageView)findViewById(R.id.iv2);

        Button btn_dpdf = (Button)findViewById(R.id.btn_dpdf);
        btn_dpdf.setOnClickListener(dpdf);

        Button btn_opdf = (Button)findViewById(R.id.btn_opdf);
        btn_opdf.setOnClickListener(opdf);

        Button btn_dzip = (Button)findViewById(R.id.btn_dzip);
        btn_dzip.setOnClickListener(dzip);
    }

    View.OnClickListener dpdf = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pdf thread = new pdf(agent2.this);
            thread.start();
        }
    };

    View.OnClickListener opdf = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            File sdroot = Environment.
                    getExternalStorageDirectory();
            File pdf = new File(sdroot, "download.pdf");
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(pdf), "application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            try {
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(agent2.this, "無法開啟PDF",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };

    View.OnClickListener dzip = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            zip thread = new zip(agent2.this, iv1, iv2);
            thread.start();
        }
    };

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Intent intent = new Intent(agent2.this, MainActivity.class);
            startActivity(intent);
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
