package com.example.sub_tracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotificationsFrag extends Fragment {

    private ArrayList<String> mTitle=new ArrayList<>();
    private ArrayList<String> mDescription=new ArrayList<>();
    private ArrayList<Integer> images=new ArrayList<>();
    NotifAdapter adapter;
    static NotificationsFrag object3;
    int p;
    CheckBox mark_as_read;

    private ArrayList<Sub> notifs;
    private RecyclerView notifs_view;
    LinearLayout Notifications_fragment;

    DatabaseHelper db;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.frag_notifications,container,false);

        Notifications_fragment = (LinearLayout) returnView.findViewById(R.id.Notifications_fragg);

        db = new DatabaseHelper(requireContext(), "subsDB.db", null, 1);

        notifs_view =  returnView.findViewById(R.id.notifs_view);
        object3=this;

        notifs_view.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));

        notifs = db.load();
        adapter = new NotifAdapter(notifs, requireContext());

        notifs_view.setAdapter(adapter);


        /*notifs_view.setOn(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),Notification_view.class);
                startActivity(intent);
                p=position;


            }
        });*/


        return returnView;
    }

    static NotificationsFrag getInstance(){
        return object3;
    }




}
