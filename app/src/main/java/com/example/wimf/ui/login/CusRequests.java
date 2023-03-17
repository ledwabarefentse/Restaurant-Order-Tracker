package com.example.wimf.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.wimf.OrderLayout;
import com.example.wimf.RequestLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CusRequests extends AppCompatActivity {
    LinearLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_all_orders);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
//        toolBarLayout.setTitle(getTitle());
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        super.onCreate(savedInstanceState);
        setContentView(content);

        final TextView t = new TextView(this);
        t.setText("View Requests by clicking the button below");
        content.addView(t);

        Button press = new Button(this);
        press.setText("View Requests");
        content.addView(press);

        container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        content.addView(container);

        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("Clicked");
                OkHttpClient client = new OkHttpClient();
                String url = "https://lamp.ms.wits.ac.za/home/s2105552/requested.php";
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            final String myResponse = response.body().string();

                            CusRequests.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    t.setText("Thank you, here is/are Requests");
                                    try {
                                        processJSON(myResponse);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        if (!response.isSuccessful()) {
                            throw new IOException("Unexpected code " + response);
                        }
                    }
                });
            }
        });
    }
    public void processJSON(String myResponse) throws JSONException {
        container.removeAllViews();
        JSONArray ja = new JSONArray(myResponse);
        for (int i = 0; i < ja.length(); i++) {
            final JSONObject jo = ja.getJSONObject(i);
            if((jo.getString("CUS_NAME")).equals(GlobalVariable2.mycusname)) {
                RequestLayout cl = new RequestLayout(this);
                cl.populate(jo);
                if (i % 2 == 0) {
                    cl.setBackgroundColor(Color.parseColor("#EEEEFF"));
                }
                container.addView(cl);

                cl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                        } finally {

                        }
                        try {
                            GlobalVariable2.mycusname = jo.getString("CUS_NAME");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.myresname = jo.getString("RES_NAME");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.mystaname = jo.getString("STA_NAME");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.mystatus = jo.getString("ORDER_STATUS");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.mydate = jo.getString("DATE_CREATED");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.myreqno = jo.getString("REQ_NO");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.custext = jo.getString("TEXT");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.statext = jo.getString("RESPONSE");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.cusdate = jo.getString("DATE_CREATED");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            GlobalVariable2.stadate = jo.getString("STA_DATE");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(CusRequests.this,ViewResponse.class);
                        startActivity(intent);
//                        Toast.makeText(AllOrders.this, "This car is "+jo.getString("AGE")+" old.", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
}