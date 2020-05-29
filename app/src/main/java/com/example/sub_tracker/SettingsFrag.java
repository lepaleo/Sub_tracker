package com.example.sub_tracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.text.TextWatcher;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFrag extends Fragment {
    private Button Proceed_Settings;
    private TextView User_profile;
    private ImageView img;
    private int[] pics={R.drawable.user_icon_pic,R.drawable.user_icon_pic_1,R.drawable.user_icon_pic_2,R.drawable.user_icon_pic,R.drawable.user_icon_pic_4};
    int flag=0,flag2=0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View returnView = inflater.inflate(R.layout.frag_settings,container,false);
        img=(ImageView)returnView.findViewById(R.id.Profile_pic);
        img.setImageResource(pics[0]);
        Switch aaSwitch=(Switch) returnView.findViewById(R.id.switch_Icon) ;
//        if (flag2 == 0) {
//            img.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    flag++;
//                    if(flag==1){
//                        img.setImageResource(pics[1]);
//                    }
//                    if(flag==2){
//                        img.setImageResource(pics[2]);
//                    }
//                    if(flag==3){
//                        img.setImageResource(pics[0]);
//                    }
//                    if(flag==4){
//                        img.setImageResource(pics[4]);
//                        flag=0;
//                    }
//                }
//            });
//        }


        aaSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {

                    img.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(isChecked){
                                flag++;
                                if(flag==1){
                                    img.setImageResource(pics[1]);
                                }
                                if(flag==2){
                                    img.setImageResource(pics[2]);
                                }
                                if(flag==3){
                                    img.setImageResource(pics[0]);
                                }
                                if(flag==4){
                                    img.setImageResource(pics[4]);
                                    flag=0;
                                }
                            }else{
                                Toast toast=Toast.makeText(getActivity(),"NO NO NO",Toast.LENGTH_SHORT);
                                toast.show();

                                flag2=1;
                            }


                        }
                    });



            }
        });



        User_profile = (TextView) returnView.findViewById(R.id.Profile_name);
        ImageButton setting_Button=(ImageButton) returnView.findViewById(R.id.Settings_button);

        setting_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Pop.class));
            }
        });

        User_profile.setText("Username");//username to be from data base
        return returnView;
    }




}
