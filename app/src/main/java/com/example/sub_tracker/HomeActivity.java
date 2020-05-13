package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class HomeActivity extends AppCompatActivity {
    TextView Username;
    public String Username2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Username=(TextView)findViewById(R.id.Username);
        final Button Proceed_button=(Button)findViewById(R.id.login_button);
        Proceed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username2=Username.getText().toString();
                GoToMainHome();
            }
        });

    }
    public  void GoToMainHome(){
        Intent intent=new Intent(this,Homepage.class);
        startActivity(intent);
    }


}
