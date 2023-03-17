package com.example.wimf;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class CusOrderLayout extends LinearLayout {
    TextView OrderNo;
    TextView ResName;
    TextView OrderStatus;
    TextView Created;

    public CusOrderLayout(Context p) {
        super(p);
        setOrientation(LinearLayout.HORIZONTAL);
        OrderNo = new TextView(p);
        ResName = new TextView(p);
        OrderStatus = new TextView(p);
        Created = new TextView(p);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.weight=0;
        OrderNo.setPadding(20,20,20,20);
        addView(OrderNo,lp);

        LinearLayout rightlayout = new LinearLayout(p);
        rightlayout.setOrientation(LinearLayout.VERTICAL);
        rightlayout.addView(ResName);
        rightlayout.addView(Created);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp2.weight=1;
        addView(rightlayout,lp2);

        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp2.weight=1;
        addView(OrderStatus,lp3);
    }
    public void populate(JSONObject jo) throws JSONException {
        OrderNo.setText(jo.getString("ORDER_NO"));
        ResName.setText(jo.getString("RES_NAME"));
        OrderStatus.setText(jo.getString("ORDER_STATUS"));
        Created.setText(jo.getString("DATE_CREATED"));
    }
}
