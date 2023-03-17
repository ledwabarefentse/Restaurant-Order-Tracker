package com.example.wimf.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wimf.R;

public class RequestedOrder extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView Trequest,Tcustomer,Tdate;
    String reqno,myresponse,staname;
    TextView response;
    EditText responded;

    @SuppressLint({"SetTextI18n", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requested_order);

        radioGroup = findViewById(R.id.radioGroup);
        response = findViewById(R.id.textView14);
        responded = findViewById(R.id.orderresponse);
        Tcustomer = findViewById(R.id.focustomer);
        Tdate = findViewById(R.id.mydate);
        Trequest = findViewById(R.id.requestno);
        Tcustomer.setText("From : "+GlobalVariable2.mycusname);
        Tdate.setText("Created On : "+GlobalVariable2.mydate);
        Trequest.setText("Request No : "+GlobalVariable2.myreqno);
        GlobalVariable2.myreqtext = response;
        reqno = GlobalVariable2.myreqno;
        GlobalVariable2.myradioButton = radioButton;
        staname = GlobalVariable2.mystaname;

    }
    public void ClickChecked(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        GlobalVariable2.myradioButton = radioButton;
//        Toast.makeText(UserActivity.this,"The order is "+ radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    public void ClickApply(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        GlobalVariable2.myradioButton = radioButton;
        myresponse = responded.getText().toString();
        staname = GlobalVariable2.mystaname;
        String method = "response";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, reqno, myresponse,staname);
        finish();
    }

    public void text(View view) {
        String method = "text";
        BackgroundTask backgroundTask = new BackgroundTask( this);
        backgroundTask.execute(method, reqno);
    }
}