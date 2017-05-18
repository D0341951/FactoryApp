package com.example.user.factoryapp;

import android.app.Activity;
import android.content.Context;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by user on 2017/5/20.
 */

public class upload extends Thread {

    FTPClient client;
    Activity activity;

    upload(Activity activity, FTPClient client) {
        this.activity = activity;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            FileOutputStream fos = activity.openFileOutput("upload.txt", Context.MODE_PRIVATE);
            final String content = "Hello Upload!";
            for (int i = 0; i < content.length(); i++)
                fos.write((int)content.charAt(i));
            fos.close();

            client.setFileType(FTP.ASCII_FILE_TYPE);
            File fileroot = activity.getFilesDir();
            FileInputStream fis = new FileInputStream(
                    new File(fileroot, "upload.txt"));
            boolean succflag = client.storeFile("./public_html/Android/upload.txt", fis);
            if (succflag) {
                Common.showToast(activity, "上傳完成");
            }
            return;
        } catch (Exception e) {
        }
        Common.showToast(activity, "上傳失敗");
    }
}
