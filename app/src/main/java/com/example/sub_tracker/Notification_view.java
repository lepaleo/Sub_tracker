package com.example.sub_tracker;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Notification_view extends AppCompatActivity {

    Button back_button;
    Button delete_button;
    TextView sub_price;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_view);
        back_button=(Button)findViewById(R.id.back_button_not);
       // delete_button=(Button)findViewById(R.id.delete_not);
        sub_price=(TextView)findViewById(R.id.sub_price);
        final Context context=getApplicationContext();
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}
