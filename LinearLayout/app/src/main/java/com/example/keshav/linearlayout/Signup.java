package com.example.keshav.linearlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    private EditText password, confirmPass, firstName, lastName, email,phoneNo;
    private Button btn;
    private String sPassword, sComnfirmPass, sfirstName, sLastName, sEmail, sGender ,sPhoneNo;
    private RadioButton male, female, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputValidation())
                    sendDetails();
            }
        });
    }

    protected boolean inputValidation() {
        getfieldVal();
        if ((!sfirstName.isEmpty()) && (!sLastName.isEmpty()) && (!sEmail.isEmpty()) && (!sPassword.isEmpty()) && (!sComnfirmPass.isEmpty()) && (!sGender.isEmpty()) && (!sPhoneNo.isEmpty())) {
            if (sPassword.equals(sComnfirmPass)) {
                if(isValidEmail(sEmail)){
                    if(sPhoneNo.length()==10)
                        return true;
                    else{
                        Toast.makeText(getApplicationContext(),"Phone number should be 10 digits",Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"invalide email",Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "Confirm Password Donot Match", Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(getApplicationContext(), "All Fields Are Required", Toast.LENGTH_SHORT).show();
        return false;
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    protected void getfieldVal() {
        sPassword = password.getText().toString();
        sComnfirmPass = confirmPass.getText().toString();
        sfirstName = firstName.getText().toString();
        sLastName = lastName.getText().toString();
        sEmail = email.getText().toString();
        if (onRadioButtonclick(male))
            sGender = male.getText().toString();
        else if (onRadioButtonclick(female))
            sGender = female.getText().toString();
        else if (onRadioButtonclick(other))
            sGender = other.getText().toString();
        sPhoneNo = phoneNo.getText().toString();

    }

    protected void init() {
        password = (EditText) findViewById(R.id.etPassword);
        confirmPass = (EditText) findViewById(R.id.etconfirmPassword);
        btn = (Button) findViewById(R.id.btnSignin);
        email = (EditText) findViewById(R.id.etEmail);
        firstName = (EditText) findViewById(R.id.etFirstName);
        lastName = (EditText) findViewById(R.id.etLastName);
        male = (RadioButton) findViewById(R.id.rdBtnMale);
        female = (RadioButton) findViewById(R.id.rdBtnFemale);
        other = (RadioButton) findViewById(R.id.rdBtnOther);
        phoneNo = (EditText) findViewById(R.id.etPhoneNo);
    }

    protected boolean onRadioButtonclick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        return checked;
    }


    protected void sendDetails() {
        Bundle bundle = new Bundle();
        bundle.putString("firstName", sfirstName);
        bundle.putString("lastName", sLastName);
        bundle.putString("email", sEmail);
        bundle.putString("gender", sGender);
        bundle.putString("phoneNo",sPhoneNo);
        Intent intent = new Intent(Signup.this, ShowUserInfo.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
