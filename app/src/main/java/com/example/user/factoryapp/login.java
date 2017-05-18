package com.example.user.factoryapp;

import android.app.Activity;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * Created by user on 2017/5/20.
 */

public class login extends Thread {

    String site, user, pwd;
    FTPClient client;
    Activity activity;

    login(Activity activity, FTPClient client, String site, String user, String pwd) {
        this.activity = activity;
        this.client = client;
        this.site = site;
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    public void run() {
        try {
            client.connect(site);
            int replycode = client.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replycode)) {
                client.disconnect();
                Common.showToast(activity, "連線失敗");
                return;
            }
            if (client.login(user, pwd)) {
                client.enterLocalPassiveMode();
                Common.showToast(activity, "登入成功");
                return;
            }
        } catch (Exception e) {
        }
        Common.showToast(activity, "登入失敗");
    }
}
