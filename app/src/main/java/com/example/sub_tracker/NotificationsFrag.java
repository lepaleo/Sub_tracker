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
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class NotificationsFrag extends Fragment {
    private ArrayList<String> mTitle=new ArrayList<>();
    private ArrayList<String> mDescription=new ArrayList<>();
    private ArrayList<Integer> images=new ArrayList<>();
    Myadapter adapter;
    static NotificationsFrag object3;
    LinearLayout Notifications_fragment;
    int p;
    CheckBox mark_as_read;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.frag_notifications,container,false);
        final ListView listView = (ListView) returnView.findViewById(R.id.List_view_nots);
        Notifications_fragment=(LinearLayout)returnView.findViewById(R.id.Notifications_fragg);
        Button button=(Button)returnView.findViewById(R.id.button2) ;
//        mark_as_read=(CheckBox)returnView.findViewById(R.id.marker);
        object3=this;
        registerForContextMenu(listView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitle.add("Spotify");
                mDescription.add("10/02/20");
                images.add(R.drawable.ic_notifications_black_24dp);
                adapter=new Myadapter(getContext(),mTitle,mDescription,images);
                listView.setAdapter(adapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),Notification_view.class);
                startActivity(intent);
                p=position;


            }
        });



        return returnView;
    }

    static NotificationsFrag getInstance(){
        return object3;
    }

    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        if(v.getId()==R.id.List_view_nots){
            ListView listView=(ListView) v;
            AdapterView.AdapterContextMenuInfo acmi=(AdapterView.AdapterContextMenuInfo) menuInfo;
            Object obj=(Object)listView.getItemAtPosition(acmi.position);

            menu.add(1,1,0,"Mark as read");
            menu.add(1,2,0,"Delete");
        }

    }

    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        if(item.getGroupId()==1){
            switch (item.getItemId()){
                case 1:
                    Toast toast=Toast.makeText(getActivity(),"Marked as read",Toast.LENGTH_SHORT);
                    toast.show();
                    return true;
                case 2:
                    String toRemove=NotificationsFrag.getInstance().adapter.getItem(NotificationsFrag.getInstance().p);
                    adapter.remove(toRemove);
                    Toast toast2=Toast.makeText(getActivity(),"Deleted",Toast.LENGTH_SHORT);
                    toast2.show();
                    return true;
            }
        }
        return false;
    }


}
