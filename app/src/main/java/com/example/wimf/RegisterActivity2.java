package com.example.wimf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import static com.example.wimf.ResStaffActivity.Raddress;
//import static com.example.wimf.ResStaffActivity.Remail;
//import static com.example.wimf.ResStaffActivity.Rname;
//import static com.example.wimf.ResStaffActivity.Rpassword;
//import static com.example.wimf.ResStaffActivity.Rphone;

public class RegisterActivity2 extends Activity {

    static EditText Resname;
    EditText Restel;
    EditText Resaddress;
    EditText Resemail;
    EditText Respass;
    EditText Rescpass;
    public static String name, phone, address, email, password;

//    public RegisterActivity2(RegisterActivity3 registerActivity3) {
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        Resname = findViewById(R.id.Name);
        Restel = findViewById(R.id.Phone);
        Resaddress = findViewById(R.id.Address);
        Resemail = findViewById(R.id.Email);
        Respass = findViewById(R.id.Password);
        Rescpass = findViewById(R.id.CPassword);


        name = Resname.getText().toString();
        email = Resemail.getText().toString();
        phone = Restel.getText().toString();
        address = Resaddress.getText().toString();
        password = Respass.getText().toString();

    }

    public void OnClickRegister3(View view) {
        if (Resname.length() == 0) {
            Resname.setError("Please enter Restaurant name");
        } else if (Restel.length() == 0) {
            Restel.setError("Please enter Restaurant telephone number");
        } else if (!(Restel.length() == 0) && !(Restel.length()==10)) {
            Restel.setError("Please enter valid telephone number");
        } else if (Resaddress.length() == 0) {
            Resaddress.setError("Please enter Restaurant address");
        } else if (!Resemail.getText().toString().isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(Resemail.getText().toString()).matches()) {
            Toast.makeText(this, "Please enter valid email address", Toast.LENGTH_SHORT).show();
            Resemail.setError("Invalid Email Address");
        } else if (Respass.length() == 0) {
            Respass.setError("Please enter password");
        } else if (Respass.length() < 5) {
            Respass.setError("Password must have at least 6 characters");
        } else if (Rescpass.length() == 0) {
            Rescpass.setError("Please confirm password");
        } else if (!(Rescpass.getText().toString()).equals(Respass.getText().toString())) {
            Rescpass.setError("Password don't match");
            Toast.makeText(this, "Please enter matching password", Toast.LENGTH_SHORT).show();
        } else {
            GlobalVariable.Rname = Resname.getText().toString();
            GlobalVariable.Remail = Resemail.getText().toString();
            GlobalVariable.Rphone = Restel.getText().toString();
            GlobalVariable.Raddress = Resaddress.getText().toString();
            GlobalVariable.Rpassword = Respass.getText().toString();
            startActivity(new Intent(this, ResStaffActivity.class));
            finish();
        }
    }
}
