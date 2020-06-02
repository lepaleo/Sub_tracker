package com.example.sub_tracker;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Change_Icons extends AppCompatActivity {
    private int[] pics={R.drawable.user_icon_pic,R.drawable.user_icon_pic_1,R.drawable.user_icon_pic_2,R.drawable.user_icon_pic,R.drawable.user_icon_pic_4};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_icons);
        ImageView img1=(ImageView)findViewById(R.id.Icon_1);
        ImageView img2=(ImageView)findViewById(R.id.Icon_2);
        ImageView img3=(ImageView)findViewById(R.id.Icon_3);
        ImageView img4=(ImageView)findViewById(R.id.Icon_4);
        ImageView img5=(ImageView)findViewById(R.id.Icon_5);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFrag.getInstance().change_icon(pics[0]);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFrag.getInstance().change_icon(pics[1]);
                finish();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFrag.getInstance().change_icon(pics[2]);
                finish();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFrag.getInstance().change_icon(pics[0]);
                finish();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsFrag.getInstance().change_icon(pics[4]);
                finish();
            }
        });
    }
}
