package com.example.keshav.linearlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {
    protected TextView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btn = (TextView) findViewById(R.id.tvSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpPage();
            }
        });
    }
    protected void signUpPage(){
        Intent nextPage = new Intent(this,Signup.class);
        startActivity(nextPage);

    }
}
