package com.example.keshav.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowUserInfo extends AppCompatActivity {
    protected TextView firstName,lastName,email,gender,phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_info);
        init();
        Bundle bundle = getIntent().getExtras();
        setDetailVal(bundle);
    }

    protected void init() {
        firstName = (TextView) findViewById(R.id.tvFirstName);
        lastName = (TextView) findViewById(R.id.tvLastName);
        email = (TextView) findViewById(R.id.tvEmail);
        gender = (TextView) findViewById(R.id.tvGender);
        phoneNo = (TextView) findViewById(R.id.tvPhoneNo);
    }

    protected void setDetailVal(Bundle bundle) {
        String val = bundle.getString("firstName");
        firstName.setText(val);
        val = bundle.getString("lastName");
        lastName.setText(val);
        val = bundle.getString("email");
        email.setText(val);
        val = bundle.getString("gender");
        gender.setText(val);
        val = bundle.getString("phoneNo");
        phoneNo.setText(val);
    }


}
