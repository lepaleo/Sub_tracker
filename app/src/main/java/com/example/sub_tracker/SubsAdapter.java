package com.example.sub_tracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubsAdapter extends RecyclerView.Adapter<SubsAdapter.ViewHolder> {

    private ArrayList<Sub> list_subs;
    private Context context;
    private Activity activity;
    DatabaseHelper db;

    public SubsAdapter(ArrayList<Sub> list_subs, Context context, Activity activity){
        this.list_subs = list_subs;
        this.context = context;
        this.activity = activity;
        db = new DatabaseHelper(context, "subsDB.db", null, 1);
    }

    @NonNull
    @Override
    public SubsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subs_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubsAdapter.ViewHolder holder, int position) {
        final Sub sub = list_subs.get(position);

        holder.sub_name.setText(sub.getSubname());
        holder.sub_price.setText(String.valueOf(sub.getPrice()));

        if(sub.get_color() != null)
            holder.subs_list.setCardBackgroundColor(Color.parseColor(sub.get_color()));

        if(sub.getEnddate() == null){
            holder.notification.setVisibility(View.GONE);
        }

        holder.subs_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(context, "SUB CLICKED NAME: " + sub.getSubname(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SubOverview.class);
                intent.putExtra("id", String.valueOf(sub.getID()));
                intent.putExtra("name", sub.getSubname());
                intent.putExtra("price", String.valueOf(sub.getPrice()));
                intent.putExtra("email", sub.getEmail());
                intent.putExtra("card", sub.getCard());
                intent.putExtra("startDate", sub.getStartdate());
                intent.putExtra("endDate", sub.getEnddate());
                activity.startActivity(intent);
                activity.finish();
            }
        });

        holder.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sub.getNotif().equals("true")){
                    sub.setNotif("true");
                    db.updateSub(sub);
                    Toast.makeText(context, "Notification enabled", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Notification already enabled", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return list_subs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        TextView sub_name, sub_price;
        CardView subs_list;
        LinearLayout sub_click;
        ImageButton notification;

        public ViewHolder(View view){
            super(view);
            this.view = view;

            sub_name = view.findViewById(R.id.sub_name);
            sub_price = view.findViewById(R.id.sub_price);
            subs_list = view.findViewById(R.id.subs_list);
            notification = view.findViewById(R.id.notification);
            sub_click = view.findViewById(R.id.sub_click);
        }
    }
}
