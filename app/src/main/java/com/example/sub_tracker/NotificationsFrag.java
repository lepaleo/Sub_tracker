package com.example.sub_tracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NotificationsFrag extends Fragment {
    private String[] mTitle={"Spotify","Spotify","Spotify","Spotify"};
    private String[] mDescription={"10/20/30","10/20/30","10/20/30","10/20/30"};
    private int[] images={R.drawable.user_icon_pic,R.drawable.user_icon_pic,R.drawable.user_icon_pic,R.drawable.user_icon_pic};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View returnView = inflater.inflate(R.layout.frag_notifications,container,false);
        ListView listView = (ListView) returnView.findViewById(R.id.List_view_nots);
        Myadapter adapter=new Myadapter(getContext(),mTitle,mDescription,images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(getContext(),"10/20/30",Toast.LENGTH_SHORT).show();
                }
                if(position==1){
                    Toast.makeText(getContext(),"10/20/30",Toast.LENGTH_SHORT).show();
                }
                if(position==2){
                    Toast.makeText(getContext(),"10/20/30",Toast.LENGTH_SHORT).show();
                }
                if(position==3){
                    Toast.makeText(getContext(),"10/20/30",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return returnView;
    }

    static class Myadapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        Myadapter(Context c,String title[],String description[],int imgs[]){
            super(c,R.layout.row,R.id.Maintext_list,title);
            this.context=c;
            this.rTitle=title;
            this.rDescription=description;
            this.rImgs=imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            @SuppressLint("ViewHolder") View row=layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images=row.findViewById(R.id.Image_nots);
            TextView mytitle=row.findViewById(R.id.Maintext_list);
            TextView myDescription=row.findViewById(R.id.Subtext_list);


            images.setImageResource(rImgs[position]);
            mytitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }
    }
}
