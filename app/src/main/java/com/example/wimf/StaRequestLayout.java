package com.example.wimf;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class StaRequestLayout extends LinearLayout {
    TextView reqno;
    TextView ResName;
    TextView Created;
    TextView CusName;

    public StaRequestLayout(Context p) {
        super(p);
        setOrientation(LinearLayout.HORIZONTAL);
        reqno = new TextView(p);
        ResName = new TextView(p);
        Created = new TextView(p);
        CusName = new TextView(p);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.weight=0;
        reqno.setPadding(20,20,20,20);
        addView(reqno,lp);

//        LinearLayout rightlayout = new LinearLayout(p);
//        rightlayout.setOrientation(LinearLayout.VERTICAL);
//        rightlayout.addView(CusName);
//        rightlayout.addView(CusName);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp2.weight=1;
        addView(CusName,lp2);

        LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp2.weight=1;
        addView(Created,lp3);
    }
    public void populate(JSONObject jo) throws JSONException {
        reqno.setText(jo.getString("REQ_NO"));
        CusName.setText(jo.getString("CUS_NAME"));
        Created.setText(jo.getString("DATE_CREATED"));
        CusName.setText(jo.getString("CUS_NAME"));
    }
}
