package com.example.sub_tracker;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Notification_view extends AppCompatActivity {

    Button back_button;
    Button delete_button;
    TextView sub_price;
    Intent intent;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_view);

        back_button=(Button)findViewById(R.id.back_button_not);

        sub_price=(TextView)findViewById(R.id.sub_price);

        delete_button = findViewById(R.id.delete_not);

        intent = getIntent();

        if(intent.getStringExtra("price") != null){
            sub_price.setText(intent.getStringExtra("price"));
        }

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}
