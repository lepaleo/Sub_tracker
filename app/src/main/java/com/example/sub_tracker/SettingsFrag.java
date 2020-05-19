package com.example.sub_tracker;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.text.TextWatcher;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFrag extends Fragment {
    private Button Proceed_Settings;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View returnView = inflater.inflate(R.layout.frag_settings,container,false);
        TextView User_profile = (TextView) returnView.findViewById(R.id.Profile_name);

        User_profile.setText("Username");//username to be from data base
        return returnView;
    }


}
