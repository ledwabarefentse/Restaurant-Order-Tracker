package com.example.wimf.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wimf.R;

public class StatusActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView Rating,Torderno,Tfocus,Tdate;
    String status,orderno;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        radioGroup = findViewById(R.id.radioGroup);
        orderno = GlobalVariable2.orderno;
        Rating = findViewById(R.id.rating);
        GlobalVariable2.myRating = Rating;
        Torderno = findViewById(R.id.myorderno);
        Tfocus = findViewById(R.id.focus);
        Tdate = findViewById(R.id.Date);
        Torderno.setText("Order No : "+GlobalVariable2.orderno);
        Tfocus.setText("For : "+GlobalVariable2.mycusname);
        Tdate.setText("Created On : "+GlobalVariable2.mydate);

    }
    public void ClickChecked(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
//        Toast.makeText(UserActivity.this,"The order is "+ radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    public void ClickApply(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        status = radioButton.getText().toString();
        String method = "status";
        BackgroundTask backgroundTask = new BackgroundTask( this);
        backgroundTask.execute(method, status,orderno);
//        finish();
    }

    public void ClickRating(View view) {
        String method = "getrating";
        BackgroundTask backgroundTask = new BackgroundTask( this);
        backgroundTask.execute(method, orderno);
//        finish();
    }
}