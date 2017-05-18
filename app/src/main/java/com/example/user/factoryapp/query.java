package com.example.user.factoryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

import java.net.URLEncoder;

public class query extends AppCompatActivity {

    Button search;
    EditText searchitem;
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_query);
        search = (Button) findViewById(R.id.search);
        searchitem = (EditText) findViewById(R.id.searchitem);
        search.setOnClickListener(googlesearch);
        wv = (WebView)findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(client);
    }
    private OnClickListener googlesearch = new OnClickListener() {

        @Override
        public void onClick(View v) {

            String keyword = searchitem.getText().toString();
            try {
                keyword = URLEncoder.encode(keyword, "UTF-8");
            } catch (Exception e) {
            }
            String url = "http://www.google.com/search?q=" + keyword;
            wv.loadUrl(url);
        }
    };
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Intent intent = new Intent(query.this, MainActivity.class);
            startActivity(intent);
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    WebViewClient client = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    };
}
