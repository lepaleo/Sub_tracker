package com.example.sub_tracker;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    private Button backButton;
    private static final String TAG = "Calendar";
    private CalendarView mCalendarView;
    String price, name, email, card, color, id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        backButton = findViewById(R.id.calendarbackbutton);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        final Intent incoming = getIntent();

        //backbutton back to home onclick
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(incoming.getStringExtra("edit") == null) {
                    Intent backactivity = new Intent(Calendar.this, AddSubscription.class);
                    backactivity.putExtra("price", price);
                    backactivity.putExtra("id", id);
                    backactivity.putExtra("name", name);
                    backactivity.putExtra("email", email);
                    backactivity.putExtra("card", card);
                    backactivity.putExtra("color", color);
                    startActivity(backactivity);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                else{
                    Intent backactivity = new Intent(Calendar.this, EditSubscription.class);
                    backactivity.putExtra("price", price);
                    backactivity.putExtra("id", id);
                    backactivity.putExtra("name", name);
                    backactivity.putExtra("email", email);
                    backactivity.putExtra("card", card);
                    backactivity.putExtra("color", color);
                    startActivity(backactivity);
                    finish();
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
            }
        });


        id = incoming.getStringExtra("id");
        price = incoming.getStringExtra("price");
        name = incoming.getStringExtra("name");
        email = incoming.getStringExtra("email");
        card = incoming.getStringExtra("card");
        color = incoming.getStringExtra("color");
        //Toast.makeText(this, price, Toast.LENGTH_SHORT).show();

        //pick date
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month+1) +"/" + year;

                if(incoming.getStringExtra("edit") == null){
                    Intent intent = new Intent(Calendar.this, AddSubscription.class);
                    intent.putExtra("id", id);
                    intent.putExtra("price", price);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("card", card);
                    intent.putExtra("color", color);

                    if(incoming.getStringExtra("date1") != null){
                        intent.putExtra("date1", incoming.getStringExtra("date1"));
                    }
                    if(incoming.getStringExtra("date2") != null){
                        intent.putExtra("date2", incoming.getStringExtra("date2"));
                    }
                    if(incoming.getStringExtra("date").equals("startDate")){
                        intent.putExtra("date1", date);
                        Toast.makeText(Calendar.this, "Start date is: " + date, Toast.LENGTH_SHORT).show();
                    }
                    if(incoming.getStringExtra("date").equals("endDate")){
                        intent.putExtra("date2", date);
                        Toast.makeText(Calendar.this, "End date is: " + date, Toast.LENGTH_SHORT).show();
                    }
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(Calendar.this, EditSubscription.class);
                    intent.putExtra("id", id);
                    intent.putExtra("price", price);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("card", card);

                    if(incoming.getStringExtra("date1") != null){
                        intent.putExtra("date1", incoming.getStringExtra("date1"));
                    }
                    if(incoming.getStringExtra("date2") != null){
                        intent.putExtra("date2", incoming.getStringExtra("date2"));
                    }
                    if(incoming.getStringExtra("date").equals("startDate")){
                        intent.putExtra("date1", date);
                        Toast.makeText(Calendar.this, "Start date is: " + date, Toast.LENGTH_SHORT).show();
                    }
                    if(incoming.getStringExtra("date").equals("endDate")){
                        intent.putExtra("date2", date);
                        Toast.makeText(Calendar.this, "End date is: " + date, Toast.LENGTH_SHORT).show();
                    }
                    startActivity(intent);
                    finish();
                }

            }
        });

        //change notificaton bar color
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.mainApp_color));
        }

    }
}
