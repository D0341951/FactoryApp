package com.example.user.factoryapp;

import android.app.Activity;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by user on 2017/6/6.
 */

public class LdoubleLargePDF extends Thread {

    LdoubleLargePDF(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        try {

            File pdf = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath(), "L雙軸延伸大容量瓶.pdf");
            FileOutputStream fos = new FileOutputStream(pdf);

            String Ldoublelargeurl = "http://pet.chumpower.com/downfile.php?id=D2016091300004_57daa64b00134_tw.pdf&type=down";

            URL url = new URL(Ldoublelargeurl);
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0 ) {
                fos.write(buffer, 0, len);
            }
            is.close();
            fos.close();
            showmsg("下載完成");
        } catch (Exception e) {
            showmsg("下載失敗");
        }
    }

    void showmsg(final String msg) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, msg,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    Activity activity;

}
