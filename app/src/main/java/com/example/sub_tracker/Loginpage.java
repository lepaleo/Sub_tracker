package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Loginpage extends AppCompatActivity {
    TextView Username;
    public String Username2;
    private Button Proceed_button;

    //Boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        Username=(TextView)findViewById(R.id.Username);
        Proceed_button = (Button)findViewById(R.id.login_button);


        Username.addTextChangedListener(loginTextWatcher);

        Proceed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username2=Username.getText().toString();
                GoToWelcomepage();
            }
        });

    }

    // Enables "PROCEED" button if user has input a name
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput = Username.getText().toString().trim();
            Proceed_button.setEnabled(!usernameInput.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    // Intent to go to the next activity
    public void GoToWelcomepage(){
        Intent intent = new Intent(this,Welcomepage.class);
        intent.putExtra("userkey",Username2);
        startActivity(intent);
        finish();
    }


}
