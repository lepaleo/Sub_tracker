package com.example.sub_tracker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private Activity activity;

    DatabaseHelper db;


    public NotifAdapter(ArrayList<Sub> notifs, Context c, Activity activity){
        this.context=c;
        this.notifs = notifs;
        this.activity = activity;

        db = new DatabaseHelper(context, "subsDB.db", null, 1);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new NotifAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Sub sub = notifs.get(position);

        holder.notif_name.setText(sub.getSubname());
        holder.notif_date.setText("Expiring in: " + sub.getExpire() + " days");

        holder.notif_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Notification_view.class);
                intent.putExtra("price", String.valueOf(sub.getPrice()));
                intent.putExtra("position", String.valueOf(position));
                activity.startActivity(intent);
            }
        });

        for(int i = 0; i < sub.getExpire(); i++){
            ImageView imageView = new ImageView(context);
            imageView.setBackgroundResource(R.drawable.ic_today_black_24dp);
            holder.days.addView(imageView);
        }

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifs.remove(position);
                sub.setNotif("false");
                db.updateSub(sub);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return notifs.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        TextView notif_name, notif_date;
        LinearLayout notif_item, days;
        ImageButton deleteBtn;

        public ViewHolder(View view){
            super(view);
            this.view = view;

            notif_name = view.findViewById(R.id.notif_name);
            notif_date = view.findViewById(R.id.notif_date);
            notif_item = view.findViewById(R.id.notif_item);
            days = view.findViewById(R.id.days);
            deleteBtn = view.findViewById(R.id.deleteBtn);

        }
    }
}
