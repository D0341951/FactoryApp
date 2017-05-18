package com.example.user.factoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class agent extends AppCompatActivity {

    EditText target, user, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent);


    }

    View.OnClickListener login = new View.OnClickListener() {
        public void onClick(View v) {
            String ftpsite = target.getText().toString();
            String username = user.getText().toString();
            String password = passwd.getText().toString();

            target = (EditText)findViewById(R.id.target);
            user = (EditText)findViewById(R.id.user);
            passwd = (EditText)findViewById(R.id.passwd);

            Button btn_login = (Button)findViewById(R.id.btn_login);
            btn_login.setOnClickListener(login);
            Intent intent = new Intent();
            intent.setClass(agent.this, updownload.class);
            intent.putExtra("FTPSITE", ftpsite);
            intent.putExtra("USERNAME", username);
            intent.putExtra("PASSWORD", password);
            startActivity(intent);
        }
    };

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Intent intent = new Intent(agent.this, MainActivity.class);
            startActivity(intent);
            this.finish();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
