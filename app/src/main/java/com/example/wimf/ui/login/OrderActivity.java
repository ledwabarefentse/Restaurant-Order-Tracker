package com.example.wimf.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wimf.R;

public class OrderActivity extends AppCompatActivity {

    EditText ETcusname;
    TextView Torder;
    Button Bplace;
    String cusname,resname,staname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ETcusname = findViewById(R.id.CusName);
        Torder = findViewById(R.id.ViewOrder);
        Bplace = findViewById(R.id.place);
    }

    public void clickplace(View view) {
        if(ETcusname.length()==0){
            ETcusname.setError("Please enter customer username");
        }
        else {
            resname = GlobalVariable2.myresname;
            staname = GlobalVariable2.mystaname;
            cusname = ETcusname.getText().toString();
            String method = "order";
            BackgroundTask backgroundTask = new BackgroundTask( this);
            backgroundTask.execute(method, cusname, resname, staname);
            ETcusname.setText(null);
//            finish();
        }
    }

    public void Orders(View view) {
        startActivity(new Intent(OrderActivity.this, StaffActivity.class));
    }

    public void allorders(View view) {
        startActivity(new Intent(OrderActivity.this, AllOrders.class));
    }

    public void ClickRequest(View view) {
        startActivity(new Intent(OrderActivity.this, ViewRequested.class));
    }
}