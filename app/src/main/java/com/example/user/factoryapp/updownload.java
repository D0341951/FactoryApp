/**
 * Created by user on 2017/5/20.
 */

package com.example.user.factoryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import org.apache.commons.net.ftp.FTPClient;


public class updownload extends ActionBarActivity {

    FTPClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_andupload);

        Intent intent = getIntent();
        String site = intent.getStringExtra("FTPSITE");
        String user = intent.getStringExtra("USERNAME");
        String pwd = intent.getStringExtra("PASSWORD");

        client = new FTPClient();

        login thread = new login(this, client, site, user, pwd);
        thread.start();

        Button upload = (Button)findViewById(R.id.upload);
        upload.setOnClickListener(upload_l);
        Button down = (Button)findViewById(R.id.download);
        down.setOnClickListener(download_l);
    }

    View.OnClickListener upload_l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (client.isConnected() == false)
                return;
            upload thread = new upload(updownload.this, client);
            thread.start();
        }
    };

    View.OnClickListener download_l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (client.isConnected() == false)
                return;
            download thread = new download(updownload.this, client);
            thread.start();
        }
    };

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Intent intent = new Intent(updownload.this, MainActivity.class);
            startActivity(intent);
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
