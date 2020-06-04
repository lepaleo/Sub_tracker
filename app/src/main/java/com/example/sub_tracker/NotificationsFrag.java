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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Math.abs;

public class NotificationsFrag extends Fragment {

    NotifAdapter adapter;
    static NotificationsFrag object3;
    private ArrayList<Sub> notifs, notifsFinal;
    private RecyclerView notifs_view;
    RelativeLayout Notifications_fragment;

    DatabaseHelper db;
    private int position;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.frag_notifications,container,false);

        Notifications_fragment = returnView.findViewById(R.id.Notifications_fragg);

        db = new DatabaseHelper(requireContext(), "subsDB.db", null, 1);

        notifs_view =  returnView.findViewById(R.id.notifs_view);
        object3=this;

        notifs_view.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        notifsFinal = new ArrayList<>();
        notifs = db.load();

        for(Sub x: notifs){
            if(x.getEnddate() != null){
                try {
                    Date todayDate = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String todayString = formatter.format(todayDate);

                    Date today = new SimpleDateFormat("dd/MM/yyyy").parse(todayString);
                    Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(x.getEnddate());

                    long milliseconds = abs(date2.getTime() - today.getTime());
                    long days = milliseconds / (1000 * 60 * 60 * 24);

                    if(days <= 5 && x.getNotif().equals("true")){
                        x.setExpire(days);
                        notifsFinal.add(x);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        adapter = new NotifAdapter(notifsFinal, requireContext(), requireActivity());

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
