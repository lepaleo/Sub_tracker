package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


public class Loginpage extends AppCompatActivity {
    public EditText Username;
    public String Username2;
    private Button ProceedBtn;
    public static final String FILE_NAME = "username.txt";
    static Loginpage obj;
    private String username, usernameCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        obj=this;

            //save the entered username
            Username = (EditText) findViewById(R.id.Username);
            ProceedBtn = (Button) findViewById(R.id.login_button);

            SharedPreferences shared = getSharedPreferences("prefs", MODE_PRIVATE);
            usernameCheck = shared.getString("username", null);

            if(usernameCheck != null){
                GoToWelcomepage(username);
            }


            Username.addTextChangedListener(loginTextWatcher);

            ProceedBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    username = Username.getText().toString();
                    GoToWelcomepage(username);
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


    // Enables "PROCEED" button if user has input a name
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput = Username.getText().toString().trim();
            ProceedBtn.setEnabled(!usernameInput.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    // Intent to go to the next activity
    public void GoToWelcomepage(String username){
        Intent intent = new Intent(this,Welcomepage.class);
        intent.putExtra("userkey",username);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    public static Loginpage getInstance(){
        return obj;
    }
}
