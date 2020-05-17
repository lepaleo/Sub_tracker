package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Welcomepage extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.mainApp_color));
        }

        /*Window window = Welcomepage.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(Welcomepage.this, R.color.colorAccent));*/

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            TextView textView2 = (TextView) findViewById(R.id.textView2);
            String value = extras.getString("userkey");
            textView2.setText("WELCOME\n\n" + value);
        }

        // Intent to go to the next activity with a splash timeout
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homepageIntent = new Intent(Welcomepage.this, Homepage.class);
                startActivity(homepageIntent);
                finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        },SPLASH_TIME_OUT);
    }
}
