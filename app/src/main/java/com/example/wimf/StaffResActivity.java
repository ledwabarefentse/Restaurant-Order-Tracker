package com.example.wimf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.wimf.ui.login.BackgroundTask;

public class StaffResActivity extends AppCompatActivity {

    EditText STname, STsurname, STusername, STIDno, STaddress, STJobtitle, STphone, STemail, STpassword, STcpassword;
    String name, surname,username, IDno, address, jobtitle, phone, email, password, Rname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

        Rname = GlobalVariable.Rname;
        name = GlobalVariable.name;
        surname = GlobalVariable.surname;
        IDno = GlobalVariable.IDno;
        phone = GlobalVariable.phone;
        username = GlobalVariable.username;
        email = GlobalVariable.email;
        address = GlobalVariable.address;
        jobtitle = GlobalVariable.jobtitle;
        password = GlobalVariable.password;
        BackgroundTask backgroundTask = new BackgroundTask( this);
        String method = "register3";
        backgroundTask.execute(method, name, surname, username, IDno, phone, email, address,Rname, jobtitle , password);
        finish();
    }
}