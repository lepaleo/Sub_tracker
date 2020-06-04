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
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.ViewHolder> {


    Context context;
    private ArrayList<Sub> notifs;


    public NotifAdapter(ArrayList<Sub> notifs, Context c){
        this.context=c;
        this.notifs = notifs;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new NotifAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sub sub = notifs.get(position);

        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sub.getStartdate());
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sub.getEnddate());
            long milliseconds = date2.getTime() - date1.getTime();

            long days = milliseconds / (1000 * 60 * 60 * 24);


            if(days <= 5){
                holder.notif_name.setText(sub.getSubname());
                holder.notif_date.setText(String.valueOf(days));
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return notifs.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        TextView notif_name, notif_date;


        public ViewHolder(View view){
            super(view);
            this.view = view;

            notif_name = view.findViewById(R.id.notif_name);
            notif_date = view.findViewById(R.id.notif_date);

        }
    }
}
