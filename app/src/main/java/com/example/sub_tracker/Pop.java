package com.example.sub_tracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.app.Instrumentation;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Pop extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        Switch aSwitch=(Switch) findViewById(R.id.switch1) ;
        Switch bSwitch=(Switch) findViewById(R.id.switch2) ;
        Button button=(Button)findViewById(R.id.button);

        final Context context=getApplicationContext();


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast=Toast.makeText(context,"On",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast=Toast.makeText(context,"Off",Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });

        bSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast=Toast.makeText(context,"On",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast=Toast.makeText(context,"Off",Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(context,Change_Icons.class));
//            }
//        });


        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width =dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.8));
    }


}
