package com.example.wimf.ui.login;

import android.app.Activity;

import com.example.wimf.ui.login.RequestHandler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProcessOrder {

    public void doRequest(final Activity a, String method, final RequestHandler rh) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(method)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    a.runOnUiThread(new Runnable() {
                        public void run() {
                            rh.processResponse(myResponse);
                        }
                    });
                }
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);

                }
            }
        });
    }
}
