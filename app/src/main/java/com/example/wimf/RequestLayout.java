package com.example.wimf;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestLayout extends LinearLayout {
    TextView reqno;
    TextView ResName;
    TextView Created;
    TextView StaName;

    public RequestLayout(Context p) {
        super(p);
        setOrientation(LinearLayout.HORIZONTAL);
        reqno = new TextView(p);
        ResName = new TextView(p);
        Created = new TextView(p);
        StaName = new TextView(p);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.weight=0;
        reqno.setPadding(20,20,20,20);
        addView(reqno,lp);

        LinearLayout rightlayout = new LinearLayout(p);
        rightlayout.setOrientation(LinearLayout.VERTICAL);
        rightlayout.addView(ResName);
        rightlayout.addView(StaName);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp2.weight=1;
        addView(rightlayout,lp2);

        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp2.weight=1;
        addView(Created,lp3);
    }
    public void populate(JSONObject jo) throws JSONException {
        reqno.setText(jo.getString("REQ_NO"));
        ResName.setText(jo.getString("RES_NAME"));
        Created.setText(jo.getString("DATE_CREATED"));
        StaName.setText(jo.getString("STA_NAME"));
    }
}
