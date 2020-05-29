package com.example.sub_tracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class Myadapter extends ArrayAdapter<String> {
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
