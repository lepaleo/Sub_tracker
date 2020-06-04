package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AddSubscription extends AppCompatActivity {

    private EditText subprice;
    private EditText subname;
    private EditText subemail;
    private EditText subcard;
    private Button backButton;
    private Button saveButton;
    private Button pickcolorButton;
    private Button startdateButton;
    private Button enddateButton;
    private int mDefaultColor;
    private String strColor;
    TextView StartDate;
    TextView EndDate;

    private String enddate;
    private String startdate;
    private Intent incomingDate;
    private ArrayList<Sub> subs;


    DatabaseHelper db;

    //private String subnamecheck;
    //private String subpricecheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsubscription);

        subprice = findViewById(R.id.Subprice);
        subname = findViewById(R.id.Subname);
        subemail = findViewById(R.id.Subemail);
        subcard = findViewById(R.id.Subcard);

        backButton = findViewById(R.id.backbutton);
        saveButton = findViewById(R.id.savebutton);
        pickcolorButton = findViewById(R.id.pickcolorbutton);
        startdateButton = findViewById(R.id.startdatebutton);
        enddateButton = findViewById(R.id.enddatebutton);

        subs = new ArrayList<>();

        db = new DatabaseHelper(this, "subsDB.db", null, 1);
        subs = db.load();

        for(Sub x: subs){
            System.out.println(x.getSubname());
        }




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


        //pick color button
        mDefaultColor = ContextCompat.getColor(AddSubscription.this, R.color.colorPrimary);
        pickcolorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker();
            }
        });


        Intent incominginfo = getIntent();
        subprice.setText(incominginfo.getStringExtra("price"));
        subname.setText(incominginfo.getStringExtra("name"));
        subemail.setText(incominginfo.getStringExtra("email"));
        subcard.setText(incominginfo.getStringExtra("card"));

        //pick start date
        incomingDate = getIntent();

        if(incomingDate.getStringExtra("date1") != null) {
            startdate = incomingDate.getStringExtra("date1");
           // Toast.makeText(this, "Start date is: " + startdate, Toast.LENGTH_SHORT).show();
        }

        if(incomingDate.getStringExtra("date2") != null){
            enddate = incomingDate.getStringExtra("date2");
          //  Toast.makeText(this, "End date is: " + enddate, Toast.LENGTH_SHORT).show();
        }

        if(incominginfo.getStringExtra("color") != null){
            strColor = incominginfo.getStringExtra("color");
            int color = Color.parseColor(strColor);
            pickcolorButton.setBackgroundColor(color);
        }


        startdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pricetext = subprice.getText().toString();
                String nametext = subname.getText().toString();
                String emailtext = subemail.getText().toString();
                String cardtext = subcard.getText().toString();

                Intent intent = new Intent(AddSubscription.this, Calendar.class);

                intent.putExtra("price", pricetext);
                intent.putExtra("name", nametext);
                intent.putExtra("email", emailtext);
                intent.putExtra("card", cardtext);
                intent.putExtra("color", strColor);
                intent.putExtra("date", "startDate");
                intent.putExtra("date2", enddate);

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

                Intent intent = new Intent(AddSubscription.this, Calendar.class);

                intent.putExtra("price", pricetext);
                intent.putExtra("name", nametext);
                intent.putExtra("email", emailtext);
                intent.putExtra("card", cardtext);
                intent.putExtra("color", strColor);
                intent.putExtra("date", "endDate");
                intent.putExtra("date1", startdate);

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
                newSub(v);
                Intent intent = new Intent(AddSubscription.this, Homepage.class);
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

    }

    //color picker
    public void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {}
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                strColor = String.format("#%06X", 0xFFFFFF & mDefaultColor);
                Toast.makeText(AddSubscription.this, "Color selected: " + strColor, Toast.LENGTH_SHORT).show();
                pickcolorButton.setBackgroundColor(mDefaultColor);

                //save color to set at recyclerview item
            }
        });
        colorPicker.show();
    }

    //add when save is clicked
    public void newSub (View v) {
        db = new DatabaseHelper(this, "subsDB.db", null, 1);
        String Subname = subname.getText().toString();
        String Subprice = subprice.getText().toString();

        if(!Subname.equals("") && !Subprice.equals("")){

            Sub found = db.findSub(subname.getText().toString());
            if (found == null){
                Sub sub = new Sub(Subname, Integer.parseInt(Subprice), subemail.getText().toString(), subcard.getText().toString(), startdate, enddate, strColor);
                db.addSub(sub);
                Toast.makeText(AddSubscription.this,"Added",Toast.LENGTH_SHORT).show();
                subname.setText("");
                subprice.setText("");
                subemail.setText("");
                subcard.setText("");
                strColor = "";
            }
            else{
                Toast.makeText(AddSubscription.this,"Sub already exists",Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Homepage.class));
        finish();
    }
}
