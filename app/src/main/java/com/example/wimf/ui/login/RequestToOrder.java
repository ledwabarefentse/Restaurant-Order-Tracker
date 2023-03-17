package com.example.wimf.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.wimf.R;

public class RequestToOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_order);
        if((GlobalVariable2.myradioButton.getText().toString()).equals("Accept")){
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute("order", GlobalVariable2.mycusname, GlobalVariable2.myresname,GlobalVariable2.mystaname);
        finish();
        }
    }
}