package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import yuku.ambilwarna.AmbilWarnaDialog;

public class EditSubscription extends AppCompatActivity {

    private EditText subname;
    private EditText subprice;
    private EditText subemail;
    private EditText subcard;
    private Button backButton;
    private Button saveButton;
    private Button startdateButton;
    private Button enddateButton;
    TextView StartDate;
    TextView EndDate;
    String startDate, endDate;
    private Intent intent, incomingDate;
    DatabaseHelper db;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_subscription);

        subname = findViewById(R.id.Subname);
        subprice = findViewById(R.id.Subprice);
        subemail = findViewById(R.id.Subemail);
        subcard = findViewById(R.id.Subcard);

        backButton = findViewById(R.id.backbutton);
        saveButton = findViewById(R.id.savebutton);
        startdateButton = findViewById(R.id.startdatebutton);
        enddateButton = findViewById(R.id.enddatebutton);

        db = new DatabaseHelper(this, "subsDB.db", null, 1);


        intent = getIntent();

        if(intent.getStringExtra("name") != null && intent.getStringExtra("price") != null){
            id = intent.getStringExtra("id");
            subname.setText(intent.getStringExtra("name"));
            subprice.setText(intent.getStringExtra("price"));
            subemail.setText(intent.getStringExtra("email"));
            subcard.setText(intent.getStringExtra("card"));
        }


        if(intent.getStringExtra("startDate") != null){
            startDate = intent.getStringExtra("startDate");
            Toast.makeText(this, "Start date is: " + startDate, Toast.LENGTH_SHORT).show();
        }

        if(intent.getStringExtra("endDate") != null){
            endDate = intent.getStringExtra("endDate");
            Toast.makeText(this, "End date is: " + endDate, Toast.LENGTH_SHORT).show();
        }

        incomingDate = getIntent();

        if(incomingDate.getStringExtra("date1") != null) {
            startDate = incomingDate.getStringExtra("date1");
        }

        if(incomingDate.getStringExtra("date2") != null){
            endDate = incomingDate.getStringExtra("date2");
        }

        //backbutton back to home onclick
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backactivity = new Intent(EditSubscription.this, Homepage.class);
                startActivity(backactivity);
                finish();
              //  overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });


        //pick start date
        startdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pricetext = subprice.getText().toString();
                String nametext = subname.getText().toString();
                String emailtext = subemail.getText().toString();
                String cardtext = subcard.getText().toString();

                Intent intent = new Intent(EditSubscription.this, Calendar.class);

                intent.putExtra("edit", "edit");
                intent.putExtra("id", id);
                intent.putExtra("price", pricetext);
                intent.putExtra("name", nametext);
                intent.putExtra("email", emailtext);
                intent.putExtra("card", cardtext);
                intent.putExtra("date", "startDate");
                intent.putExtra("date2", endDate);

                startActivity(intent);
                finish();
            }
        });

        enddateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pricetext = subprice.getText().toString();
                String nametext = subname.getText().toString();
                String emailtext = subemail.getText().toString();
                String cardtext = subcard.getText().toString();

                Intent intent = new Intent(EditSubscription.this, Calendar.class);

                intent.putExtra("edit", "edit");
                intent.putExtra("id", id);
                intent.putExtra("price", pricetext);
                intent.putExtra("name", nametext);
                intent.putExtra("email", emailtext);
                intent.putExtra("card", cardtext);
                intent.putExtra("date", "endDate");
                intent.putExtra("date1", startDate);

                startActivity(intent);
                finish();
            }
        });


        //save sub
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clickable only if name and price are filled
                //save db
                Intent intent = new Intent(EditSubscription.this, Homepage.class);
                startActivity(intent);
                Toast.makeText(EditSubscription.this, "StartDate: "+ startDate, Toast.LENGTH_SHORT).show();
                Toast.makeText(EditSubscription.this, "EndDate: "+ endDate, Toast.LENGTH_SHORT).show();
                Sub sub = new Sub(Integer.parseInt(id), subname.getText().toString(), Integer.parseInt(subprice.getText().toString()), subemail.getText().toString(), subcard.getText().toString(),startDate, endDate);
                db.updateSub(sub);
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

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backactivity = new Intent(EditSubscription.this, Homepage.class);
        startActivity(backactivity);
        finish();
    }

    //
}
