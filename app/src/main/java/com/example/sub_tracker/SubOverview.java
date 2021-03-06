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
import android.widget.Toast;

import org.w3c.dom.Text;

public class SubOverview extends AppCompatActivity {

    private Button backButton;
    private Button editButton, deleteBtn;
    private TextView subprice;
    private TextView subname;
    private TextView subemail;
    private TextView subcard;
    private TextView startDate;
    private TextView endDate;
    private Intent intent;
    private String id;

    DatabaseHelper db;
    private Sub sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_overview);

        db = new DatabaseHelper(this, "subsDB.db", null, 1);

        backButton = findViewById(R.id.backbutton);
        deleteBtn = findViewById(R.id.deleteBtn);
        subname = findViewById(R.id.Subname);
        subprice = findViewById(R.id.Subprice);
        subemail = findViewById(R.id.Subemail);
        subcard = findViewById(R.id.Subcard);
        startDate = findViewById(R.id.Startdate);
        endDate = findViewById(R.id.Enddate);

        intent = getIntent();

        if(intent.getStringExtra("name") != null && intent.getStringExtra("price") != null) {
            id = intent.getStringExtra("id");
            subname.setText(intent.getStringExtra("name"));
            subprice.setText(intent.getStringExtra("price"));
            subcard.setText(intent.getStringExtra("card"));
            subemail.setText(intent.getStringExtra("email"));
            startDate.setText(intent.getStringExtra("startDate"));
            endDate.setText(intent.getStringExtra("endDate"));
        }


        //backbutton back to home onclick
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backactivity = new Intent(SubOverview.this, Homepage.class);
                startActivity(backactivity);
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });


        editButton = findViewById(R.id.editbutton);

        //editbutton to edit subcsciption activity
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubOverview.this, EditSubscription.class);
               // Toast.makeText(SubOverview.this, subprice.getText().toString(), Toast.LENGTH_SHORT).show();
                intent.putExtra("id", id);
                intent.putExtra("name", subname.getText().toString());
                intent.putExtra("price", subprice.getText().toString());
                intent.putExtra("email", subemail.getText().toString());
                intent.putExtra("card", subcard.getText().toString());
                intent.putExtra("startDate", startDate.getText().toString());
                intent.putExtra("endDate", endDate.getText().toString());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteSub(Integer.parseInt(id));
                Intent intent = new Intent(getApplicationContext(), Homepage.class);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backactivity = new Intent(SubOverview.this, Homepage.class);
        startActivity(backactivity);
        finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}
