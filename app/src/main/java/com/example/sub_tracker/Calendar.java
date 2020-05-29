package com.example.sub_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    private Button backButton;
    private static final String TAG = "Calendar";
    private CalendarView mCalendarView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        backButton = findViewById(R.id.calendarbackbutton);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        //backbutton back to home onclick
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backactivity = new Intent(Calendar.this, AddSubscription.class);
                startActivity(backactivity);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + (month+1) +"/" + year;

                Intent intent = new Intent(Calendar.this, AddSubscription.class);
                intent.putExtra("date", date);
                startActivity(intent);
                finish();
            }
        });
    }
}
