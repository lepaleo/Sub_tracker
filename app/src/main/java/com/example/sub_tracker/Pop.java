package com.example.sub_tracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.app.Instrumentation;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Pop extends AppCompatActivity  {

    static final String SHARED_PREFS="sharedPrefs";
    static final String ASWITCH="switch1";
    Switch aSwitch;
    Switch bSwitch;
    private boolean switchonoff;
    static Pop object3;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        aSwitch=(Switch) findViewById(R.id.switch1) ;
        bSwitch=(Switch) findViewById(R.id.switch2) ;
        Button button=(Button)findViewById(R.id.button);
        RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        final TextView textView=(TextView)findViewById(R.id.Rating_logo);
        object3=this;

        final Context context=getApplicationContext();

        ratingBar.setMax(5);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast toast=Toast.makeText(context,"Thank you",Toast.LENGTH_SHORT);
                toast.show();
                ratingBar.setIsIndicator(true);
                ratingBar.setEnabled(false);
                textView.setText(" ");
            }
        });



        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast toast=Toast.makeText(context,"On",Toast.LENGTH_SHORT);
                    toast.show();
                    Homepage.getInstance().bottom_nav.getMenu().getItem(1).setEnabled(false);
                }else{
                    Toast toast=Toast.makeText(context,"Off",Toast.LENGTH_SHORT);
                    toast.show();
                    Homepage.getInstance().bottom_nav.getMenu().getItem(1).setEnabled(true);
                }
            }
        });

        bSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                   Toast toast=Toast.makeText(context,"On",Toast.LENGTH_SHORT);
                   toast.show();
                   HomeFrag.getInstance().Home_fragment.setBackground(getDrawable(R.drawable.gradient_backround_2));
                   SettingsFrag.getInstance().Settings_fragment.setBackground(getDrawable((R.drawable.gradient_backround_2)));
                   NotificationsFrag.getInstance().Notifications_fragment.setBackground(getDrawable(R.drawable.gradient_backround_2));
                }else{
                    Toast toast=Toast.makeText(context,"Off",Toast.LENGTH_SHORT);
                    toast.show();
                    HomeFrag.getInstance().Home_fragment.setBackground(getDrawable(R.drawable.gradient_background));
                    SettingsFrag.getInstance().Settings_fragment.setBackground(getDrawable((R.drawable.gradient_background)));
                    NotificationsFrag.getInstance().Notifications_fragment.setBackground(getDrawable(R.drawable.gradient_background));

                }
//                saveData();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,Change_Icons.class));
            }
        });


        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width =dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.8));

    }

    public static Pop getInstance(){return object3;}

//    public void saveData(){
//        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPreferences.edit();
//
//        editor.putBoolean(ASWITCH,bSwitch.isChecked());
//        editor.apply();
//    }
//
//    public void loadData(){
//        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
//        switchonoff=sharedPreferences.getBoolean(ASWITCH,false);
//    }
//
//    public void updateViews(){
//        bSwitch.setChecked(switchonoff);
//    }

}
