package com.example.wimf.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wimf.R;


public class RegisterActivity3 extends Activity {

    EditText STname, STsurname, STusername, STIDno, STaddress, STJobtitle, STphone, STemail, STpassword, STcpassword;
    String name, surname,username, IDno, address, jobtitle, phone, email,password,Rname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        STname = findViewById(R.id.Name);
        STsurname = findViewById(R.id.Surname);
        STusername = findViewById(R.id.Username);
        STIDno = findViewById(R.id.IDno);
        STJobtitle = findViewById(R.id.Jobtitle);
        STaddress = findViewById(R.id.Address);
        STphone = findViewById(R.id.Phone);
        STemail = findViewById(R.id.Email);
        STpassword = findViewById(R.id.Password);
        STcpassword = findViewById(R.id.CPassword);

    }

    public void OnClickRegister3(View view) {
        if (STname.length() == 0) {
            STname.setError("Please enter your name");
        } else if (STsurname.length() == 0) {
            STsurname.setError("Please enter your surname");
        } else if (STusername.length() == 0) {
            STusername.setError("Please enter your username");
        } else if (STIDno.length() == 0) {
            STIDno.setError("Please enter your ID number");
        } else if (!(STIDno.length() == 0) && !(STIDno.length()==13)) {
            STIDno.setError("Please enter valid ID number");
        } else if (STphone.length() == 0) {
            STphone.setError("Please enter your phone number");
        } else if (!(STphone.length() == 0) && !(STphone.length()==10)) {
            STphone.setError("Please enter valid phone number");
        } else if (!STemail.getText().toString().isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(STemail.getText().toString()).matches()) {
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
            STemail.setError("Invalid Email Address");
        } else if (STaddress.length() == 0) {
            STaddress.setError("Please enter your address");
        } else if (STJobtitle.length() == 0) {
            STJobtitle.setError("Please enter your Job Title");
        } else if (STpassword.length() == 0) {
            STpassword.setError("Please enter password");
        } else if (STpassword.length() < 5) {
            STpassword.setError("Password must have at least 6 characters");
        } else if (STcpassword.length() == 0) {
            STcpassword.setError("Please confirm your password");
        } else if (!(STcpassword.getText().toString()).equals(STpassword.getText().toString())) {
            STcpassword.setError("Password don't match");
            Toast.makeText(this, "Please enter matching password", Toast.LENGTH_SHORT).show();
        } else {
            Rname = GlobalVariable2.myresname;
            name = STname.getText().toString();
            surname = STsurname.getText().toString();
            IDno = STIDno.getText().toString();
            phone = STphone.getText().toString();
            username = STusername.getText().toString();
            email = STemail.getText().toString();
            address = STaddress.getText().toString();
            jobtitle = STJobtitle.getText().toString();
            password = STpassword.getText().toString();
            String method = "register3";
            BackgroundTask backgroundTask = new BackgroundTask( this);
            backgroundTask.execute(method, name, surname, username, IDno, phone, email, address,Rname ,jobtitle, password);
            finish();
        }
    }
}