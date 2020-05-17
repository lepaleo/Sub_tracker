package com.example.sub_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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
import android.widget.TextView;

public class Loginpage extends AppCompatActivity {
    TextView Username;
    public String Username2;
    private Button Proceed_button;

    //Boolean firstTime = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.mainApp_color));
        }

        /*Window window = Loginpage.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(Loginpage.this, R.color.colorAccent));*/

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
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }


}
