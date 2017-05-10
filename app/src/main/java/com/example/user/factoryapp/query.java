package com.example.user.factoryapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.NetworkInfo;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class query extends AppCompatActivity {

    Button search;
    EditText searchitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE );
        //getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_query);
        search = (Button) findViewById(R.id.search);
        searchitem = (EditText) findViewById(R.id.searchitem);
        search.setOnClickListener(googlesearch);
    }
    private OnClickListener googlesearch = new OnClickListener() {

        @Override
        public void onClick(View v) {

            String input = searchitem.getText().toString();
            searchitem.setText("");
            Uri uri = Uri.parse("https://www.google.com/search?safe=off&q="+input);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
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
}
