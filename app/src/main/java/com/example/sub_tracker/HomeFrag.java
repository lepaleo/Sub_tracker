package com.example.sub_tracker;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class HomeFrag extends Fragment {

    Button addsub;
    static HomeFrag object2;
    ListView listViewSubs;
    RelativeLayout Home_fragment;
    Myadapter adapter;


    public HomeFrag(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_home,container,false);

        object2=this;
        listViewSubs=(ListView)v.findViewById(R.id.List_view_subs);
        Home_fragment=(RelativeLayout)v.findViewById(R.id.Home_fragg);
        addsub = v.findViewById(R.id.addsubbutton);
        addsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AddSubscription.class));
                getActivity().finish();
            }
        });
//        try {
//            listViewSubs.setAdapter(adapter=new Myadapter(getContext(),AddSubscription.getInstance().mTitle,AddSubscription.getInstance().mDescription,AddSubscription.getInstance().images));
//
//        }catch (NullPointerException e){
//          e.printStackTrace();
//        }



        return v;
    }



    public static HomeFrag getInstance(){
        return object2;
    }
}
