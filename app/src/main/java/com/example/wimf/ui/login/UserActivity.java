package com.example.wimf.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wimf.R;

public class UserActivity extends AppCompatActivity {

    String rate,orderno;
    TextView Torder,Tres,Tstaff,Tdate;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        orderno = GlobalVariable2.orderno;
        Torder = findViewById(R.id.orderno);
        Tres = findViewById(R.id.fromres);
        Tstaff = findViewById(R.id.bystaff);
        Tdate = findViewById(R.id.mydate);

        Torder.setText("Order No : "+GlobalVariable2.orderno);
        Tres.setText("From : "+GlobalVariable2.myresname);
        Tstaff.setText("By : "+GlobalVariable2.mystaname);
        Tdate.setText("Created On : "+GlobalVariable2.mydate);

    }

    public void tup(View view) {
        String method = "rating";
        rate = "Thumbs Up";
        BackgroundTask backgroundTask = new BackgroundTask( this);
        backgroundTask.execute(method, rate,orderno);
        finish();
    }

    public void tdown(View view) {
        String method = "rating";
        rate = "Thumbs Down";
        BackgroundTask backgroundTask = new BackgroundTask( this);
        backgroundTask.execute(method, rate,orderno);
        finish();
    }
}
