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
import android.widget.EditText;
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SettingsFrag extends Fragment {
    private Button Proceed_Settings;
    private TextView User_profile;
    private ImageView img;
    private EditText input_set;
    private Button change_button;
    private TextView choose_text;
    static SettingsFrag object;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View returnView = inflater.inflate(R.layout.frag_settings,container,false);
        img=(ImageView)returnView.findViewById(R.id.Profile_pic);
        object=this;
        input_set=(EditText) returnView.findViewById(R.id.Input_settings) ;
        change_button=(Button)returnView.findViewById(R.id.Change_name_button);
        choose_text=(TextView)returnView.findViewById(R.id.Text_choose_icon);

//        Switch aaSwitch=(Switch) returnView.findViewById(R.id.switch_Icon) ;

        input_set.addTextChangedListener(loginTextWatcher);

        change_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loginpage.getInstance().Username2 = input_set.getText().toString();

                input_set.getText().clear();
                User_profile.setText(Loginpage.getInstance().Username2);
            }
        });


//        aaSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
//
//                    img.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            if(isChecked){
//                                flag++;
//                                if(flag==1){
//                                    img.setImageResource(pics[1]);
//                                }
//                                if(flag==2){
//                                    img.setImageResource(pics[2]);
//                                }
//                                if(flag==3){
//                                    img.setImageResource(pics[0]);
//                                }
//                                if(flag==4){
//                                    img.setImageResource(pics[4]);
//                                    flag=0;
//                                }
//                            }else{
//                                Toast toast=Toast.makeText(getActivity(),"NO NO NO",Toast.LENGTH_SHORT);
//                                toast.show();
//
//                                flag2=1;
//                            }
//
//
//                        }
//                    });
//
//
//
//            }
//        });



        User_profile = (TextView) returnView.findViewById(R.id.Profile_name);
        ImageButton setting_Button=(ImageButton) returnView.findViewById(R.id.Settings_button);

        setting_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Pop.class));
            }
        });

        User_profile.setText(Loginpage.getInstance().Username2);//username to be from data base
        return returnView;
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput = input_set.getText().toString().trim();
            change_button.setEnabled(!usernameInput.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public static SettingsFrag getInstance(){
        return object;
    }

    public void change_icon(int p){
        img.setImageResource(p);
        choose_text.setText(" ");
    }



}
