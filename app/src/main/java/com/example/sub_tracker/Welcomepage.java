package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Welcomepage extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(Welcomepage.this, Loginpage.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            TextView textView2 = (TextView) findViewById(R.id.textView2);
            String value = extras.getString("userkey");
            textView2.setText("WELCOME " + value);
        }

    }
    public void GoToHomepage(){
        Intent intent=new Intent(this,Homepage.class);
        startActivity(intent);
    }
}
