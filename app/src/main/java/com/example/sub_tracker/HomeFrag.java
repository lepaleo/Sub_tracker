package com.example.sub_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFrag extends Fragment {

    Button addsub;
    static HomeFrag object2;
    ListView listViewSubs;


    public HomeFrag(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_home,container,false);

        object2=this;
        listViewSubs=(ListView)v.findViewById(R.id.List_view_subs);
        addsub = v.findViewById(R.id.addsubbutton);
        addsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AddSubscription.class));
            }
        });

        return v;
    }

    public static HomeFrag getInstance(){
        return object2;
    }
}
