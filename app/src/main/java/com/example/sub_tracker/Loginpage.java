package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Loginpage extends AppCompatActivity {
    TextView Username;
    public String Username2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        Username=(TextView)findViewById(R.id.Username);
        final Button Proceed_button=(Button)findViewById(R.id.login_button);
        Proceed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username2=Username.getText().toString();
                GoToWelcomepage();
            }
        });

    }
    public void GoToWelcomepage(){
        Intent intent = new Intent(this,Welcomepage.class);
        intent.putExtra("userkey",Username2);
        startActivity(intent);
    }


}
