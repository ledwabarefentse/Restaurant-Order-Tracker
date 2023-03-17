package com.example.wimf.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wimf.R;

public class ViewResponse extends AppCompatActivity {

    TextView REQNO,RESNAME,TEXT,CUSDATE,STANAME,STATEXT,STADATE;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_response);

        REQNO = findViewById(R.id.responseno);
        RESNAME = findViewById(R.id.reqrestaurant);
        TEXT = findViewById(R.id.description);
        CUSDATE = findViewById(R.id.reqcreated);
        STANAME = findViewById(R.id.Responder);
        STATEXT = findViewById(R.id.ResponseBy);
        STADATE = findViewById(R.id.ResponderDate);

        REQNO.setText("Request No : "+GlobalVariable2.myreqno);
        RESNAME.setText("To : "+GlobalVariable2.myresname);
        TEXT.setText(GlobalVariable2.custext);
        CUSDATE.setText("Sent On : "+GlobalVariable2.cusdate);
        STANAME.setText("By : "+GlobalVariable2.mystaname);
        STATEXT.setText(GlobalVariable2.statext);
        STADATE.setText("Replied On : "+GlobalVariable2.stadate);
    }
}