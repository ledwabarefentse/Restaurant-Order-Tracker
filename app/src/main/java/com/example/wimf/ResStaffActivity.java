package com.example.wimf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wimf.ui.login.BackgroundTask;


public class ResStaffActivity extends Activity {

    EditText STname, STsurname, STusername, STIDno, STaddress, STJobtitle, STphone, STemail, STpassword, STcpassword;
    String name, surname,username, IDno, address, jobtitle, phone, email, password,Rname,Remail,Rphone,Raddress,Rpassword;

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
        } else if (STphone.length() == 0) {
            STphone.setError("Please enter your phone number");
        } else if (!STemail.getText().toString().isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(STemail.getText().toString()).matches()) {
            Toast.makeText(this, "Enter valid email address", Toast.LENGTH_SHORT).show();
            STemail.setError("Invalid Email Address");
        } else if (STaddress.length() == 0) {
            STname.setError("Please enter your address");
        } else if (STJobtitle.length() == 0) {
            STJobtitle.setError("Please enter your Job Title");
        } else if (STpassword.length() == 0) {
            STpassword.setError("Please enter password");
        } else if (STcpassword.length() == 0) {
            STcpassword.setError("Please confirm your password");
        } else if (!(STcpassword.getText().toString()).equals(STpassword.getText().toString())) {
            STcpassword.setError("Password don't match");
            Toast.makeText(this, "Please enter matching password", Toast.LENGTH_SHORT).show();
        } else{
            GlobalVariable.name = STname.getText().toString();
            GlobalVariable.surname = STsurname.getText().toString();
            GlobalVariable.IDno = STIDno.getText().toString();
            GlobalVariable.phone = STphone.getText().toString();
            GlobalVariable.username = STusername.getText().toString();
            GlobalVariable.email = STemail.getText().toString();
            GlobalVariable.address = STaddress.getText().toString();
            GlobalVariable.jobtitle = STJobtitle.getText().toString();
            GlobalVariable.password = STpassword.getText().toString();

            Rname = GlobalVariable.Rname;
            Remail = GlobalVariable.Remail;
            Rphone = GlobalVariable.Rphone;
            Raddress = GlobalVariable.Raddress;
            Rpassword = GlobalVariable.Rpassword;
            BackgroundTask backgroundTask = new BackgroundTask(this);
            String Rmethod = "register2";
            backgroundTask.execute(Rmethod,Rname,Remail,Rphone,Raddress,Rpassword);
            finish();
        }
    }
}