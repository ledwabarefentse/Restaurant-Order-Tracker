package com.example.wimf.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.wimf.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RequestOrder extends AppCompatActivity {

    Spinner spinner;
    ArrayList<String> list = new ArrayList<>();
    EditText mytext;
    String resname,cusname,text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_order);

        mytext = findViewById(R.id.editTextTextMultiLine);
        final ProcessOrder req = new ProcessOrder();
        req.doRequest(RequestOrder.this, "https://lamp.ms.wits.ac.za/home/s2105552/restaurants.php", new RequestHandler() {
            @Override
            public void processResponse(String response) {
                try {
                    processJSON(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        spinner = findViewById(R.id.spinner);

        list.add("RESTAURANTS");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,list);

        spinner.setAdapter(adapter);

    }
    public void processJSON(String myResponse) throws JSONException {
        JSONArray ja = new JSONArray(myResponse);
        for (int i = 0; i < ja.length(); i++) {
            final JSONObject jo = ja.getJSONObject(i);
            list.add(jo.getString("RES_NAME"));
            if (i%2==0){
                spinner.setBackgroundColor(Color.parseColor("#EEEEFF"));
            }
        }
    }

    public void ClickOrder(View view) {
        if(spinner.getSelectedItem().toString()=="RESTAURANTS"){
        }
        resname =  spinner.getSelectedItem().toString();
        cusname = GlobalVariable2.mycusname;
        text = mytext.getText().toString();
        String method = "request";
        BackgroundTask backgroundTask = new BackgroundTask( this);
        backgroundTask.execute(method, resname, cusname, text );
//        finish();
        mytext.setText(null);
        spinner.setSelection(0);
    }

    public void ClickMyorders(View view) {
        startActivity(new Intent(RequestOrder.this, CustomerActivity.class));
    }

    public void ClickReq(View view) {
        startActivity(new Intent(RequestOrder.this, CusRequests.class));
    }
}