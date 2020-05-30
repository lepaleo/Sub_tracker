package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddSubscription extends AppCompatActivity {

    private EditText subname;
    private EditText subprice;
    private EditText subemail;
    private EditText subcard;
    private Button backButton;
    private Button saveButton;
    private Button pickcolorButton;
    private Button startdateButton;
    private Button enddateButton;
TextView StartDate;
TextView EndDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsubscription);

        subname = findViewById(R.id.Subname);
        subprice = findViewById(R.id.Subprice);
        subemail = findViewById(R.id.Subemail);
        subcard = findViewById(R.id.Subcard);

        backButton = findViewById(R.id.backbutton);
        saveButton = findViewById(R.id.savebutton);
        pickcolorButton = findViewById(R.id.pickcolorbutton);
        startdateButton = findViewById(R.id.startdatebutton);
        enddateButton = findViewById(R.id.enddatebutton);

        //backbutton back to home onclick
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backactivity = new Intent(AddSubscription.this, Homepage.class);
                startActivity(backactivity);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });





        Intent incomingStartDate = getIntent();
        String startdate = incomingStartDate.getStringExtra("date");

        startdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSubscription.this, Calendar.class);
                startActivity(intent);
                finish();
            }
        });

        Intent incomingEndDate = getIntent();
        String Enddate = incomingEndDate.getStringExtra("date");

        enddateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSubscription.this, Calendar.class);
                startActivity(intent);
                finish();
            }
        });



        //change notificaton bar color
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.mainApp_color));
        }




        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}
