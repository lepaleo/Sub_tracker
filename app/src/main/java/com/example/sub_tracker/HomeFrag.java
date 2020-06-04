package com.example.sub_tracker;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFrag extends Fragment {

    Button addsub;
    static HomeFrag object2;
    RecyclerView subs;
    ArrayList<Sub> list_subs;
    DatabaseHelper db;
    private SubsAdapter subsAdapter;
    RelativeLayout Home_fragment;


    public HomeFrag(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_home,container,false);

        Home_fragment = (RelativeLayout)v.findViewById(R.id.Home_fragg);

        db = new DatabaseHelper(requireContext(), "subsDB.db", null, 1);
        list_subs = db.load();


        object2 = this;
        subs = v.findViewById(R.id.subs);
        addsub = v.findViewById(R.id.addsubbutton);
        addsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AddSubscription.class));
                requireActivity().finish();
            }
        });

        subsAdapter = new SubsAdapter(list_subs, requireContext(), requireActivity());

        subs.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        subs.setAdapter(subsAdapter);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        list_subs = db.load();
        if(subsAdapter != null)
            subsAdapter.notifyDataSetChanged();
    }

    public static HomeFrag getInstance(){
        return object2;
    }
}
