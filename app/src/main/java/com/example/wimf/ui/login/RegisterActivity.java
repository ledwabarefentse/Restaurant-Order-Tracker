package com.example.wimf.ui.login;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wimf.R;
import com.example.wimf.RegisterActivity2;

import java.util.Calendar;

public class RegisterActivity extends Activity {

    private static final String TAG = "RegisterActivity";
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    EditText ETname,ETsurname,ETusername,ETphone,ETemail,ETpassword,ETcpassword;
    TextView ETDOB;
    String name,surname,username,DOB,phone,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ETname = findViewById(R.id.Name);
        ETsurname = findViewById(R.id.Surname);
        ETusername = findViewById(R.id.Code);
        ETDOB = findViewById(R.id.IDno);
        ETphone = findViewById(R.id.Phone);
        ETemail = findViewById(R.id.Email);
        ETpassword = findViewById(R.id.Password);
        ETcpassword = findViewById(R.id.CPassword);

        ETDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        RegisterActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG,"onDateSet: yyyy-mm-dd: " + year + "-" + month + "-" + dayOfMonth);
                String date = year + "-" + month + "-" + dayOfMonth;
                ETDOB.setText(date);
            }
        };



    }

    public void OnClickRegister(View view){
        if(ETname.length()==0){
            ETname.setError("Please enter your name");
        }
        else if(ETsurname.length()==0){
            ETsurname.setError("Please enter your surname");
        }
        else if(ETusername.length()==0){
            ETusername.setError("Please enter your username");
        }
        else if(!ETemail.getText().toString().isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(ETemail.getText().toString()).matches()){
            Toast.makeText(this,"Enter valid email address",Toast.LENGTH_SHORT).show();
            ETemail.setError("Invalid Email Address");
        }
        else if(ETphone.length()==0){
            ETphone.setError("Please enter your phone number");
        }
        else if(!(ETphone.length()==0) && !(ETphone.length()==10)){
            ETphone.setError("Please enter valid phone number");
        }
        else if(ETpassword.length()==0){
            ETpassword.setError("Please enter password");
        }
        else if(ETpassword.length()<5){
            ETpassword.setError("Password must have at least 6 characters");
        }
        else if(ETcpassword.length()==0){
            ETcpassword.setError("Please confirm your password");
        }
        else if(!(ETcpassword.getText().toString()).equals(ETpassword.getText().toString())){
            ETcpassword.setError("Password don't match");
            Toast.makeText(this,"Please enter matching password",Toast.LENGTH_SHORT).show();
        }
        else {
            GlobalVariable2.myusername = ETusername;
            name = ETname.getText().toString();
            surname = ETsurname.getText().toString();
            username = ETusername.getText().toString();
            DOB = ETDOB.getText().toString();
            phone = ETphone.getText().toString();
            email = ETemail.getText().toString();
            password = ETpassword.getText().toString();
            String method = "register";
            BackgroundTask backgroundTask = new BackgroundTask( this);
            backgroundTask.execute(method, name, surname, username, DOB, phone, email, password);
            finish();
        }
    }

    public void signupStaff(View view) {
        startActivity(new Intent(RegisterActivity.this, RegisterActivity2.class));
    }
}
