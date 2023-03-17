package com.example.wimf.ui.login;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Rating;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.wimf.StaffResActivity;
import com.example.wimf.ui.login.AllOrders;
import com.example.wimf.ui.login.CustomerActivity;
import com.example.wimf.ui.login.LoginActivity;
import com.example.wimf.ui.login.OrderActivity;
import com.example.wimf.ui.login.StalogActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundTask extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context ctx;

    public BackgroundTask(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Information...");
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected String doInBackground(String... params) {
        String reg_url = "https://lamp.ms.wits.ac.za/home/s2105552/register.php";
        String reg2_url = "https://lamp.ms.wits.ac.za/home/s2105552/register2.php";
        String reg3_url = "https://lamp.ms.wits.ac.za/home/s2105552/register3.php";
        String login_url = "https://lamp.ms.wits.ac.za/home/s2105552/login.php";
        String login2_url = "https://lamp.ms.wits.ac.za/home/s2105552/login2.php";
        String order_url = "https://lamp.ms.wits.ac.za/home/s2105552/order.php";
        String status_url = "https://lamp.ms.wits.ac.za/home/s2105552/status.php";
        String rating_url = "https://lamp.ms.wits.ac.za/home/s2105552/rating.php";
        String getrating_url = "https://lamp.ms.wits.ac.za/home/s2105552/getrating.php";
        String request_url = "https://lamp.ms.wits.ac.za/home/s2105552/request.php";
        String gettext_url = "https://lamp.ms.wits.ac.za/home/s2105552/gettext.php";
        String response_url = "https://lamp.ms.wits.ac.za/home/s2105552/reqresponse.php";




        String method = params[0];
        if (method.equals("register")) {
            String name = params[1];
            String surname = params[2];
            String username = params[3];
            String DOB = params[4];
            String phone = params[5];
            String email = params[6];
            String password = params[7];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("surname", "UTF-8") + "=" + URLEncoder.encode(surname, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("DOB", "UTF-8") + "=" + URLEncoder.encode(DOB, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Customer Registration Successful...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("register2")) {
            String name = params[1];
            String phone = params[3];
            String address = params[4];
            String email = params[2];
            String password = params[5];
            try {
                URL url = new URL(reg2_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS2 = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS2, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS2.close();
                InputStream IS2 = httpURLConnection.getInputStream();
                IS2.close();
                return "Restaurant Registration Successful...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("register3")) {
            String name = params[1];
            String surname = params[2];
            String username = params[3];
            String IDno = params[4];
            String phone = params[5];
            String email = params[6];
            String address = params[7];
            String restaurant = params[8];
            String job = params[9];
            String password = params[10];
            try {
                URL url = new URL(reg3_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("surname", "UTF-8") + "=" + URLEncoder.encode(surname, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("IDno", "UTF-8") + "=" + URLEncoder.encode(IDno, "UTF-8") + "&" +
                        URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                        URLEncoder.encode("job", "UTF-8") + "=" + URLEncoder.encode(job, "UTF-8") + "&" +
                        URLEncoder.encode("restaurant", "UTF-8") + "=" + URLEncoder.encode(restaurant, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Staff Registration Successful...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("request")) {
            String resname = params[1];
            String cusname = params[2];
            String text = params[3];
            try {
                URL url = new URL(request_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS2 = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS2, "UTF-8"));
                String data = URLEncoder.encode("resname", "UTF-8") + "=" + URLEncoder.encode(resname, "UTF-8") + "&" +
                        URLEncoder.encode("cusname", "UTF-8") + "=" + URLEncoder.encode(cusname, "UTF-8") + "&" +
                        URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode(text, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS2.close();
                InputStream IS2 = httpURLConnection.getInputStream();
                IS2.close();
                return "Request Successful...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("order")){
            String cusname = params[1];
            String resname = params[2];
            String staname = params[3];
            try {
                URL url = new URL(order_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("cusname","UTF-8") + "=" + URLEncoder.encode(cusname,"UTF-8")+"&"+
                        URLEncoder.encode("resname","UTF-8") + "=" + URLEncoder.encode(resname,"UTF-8")+"&"+
                        URLEncoder.encode("staname","UTF-8") + "=" + URLEncoder.encode(staname,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Order Successfully Placed";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("status")){
            String status = params[1];
            String orderno = params[2];
            try {
                URL url = new URL(status_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("status","UTF-8") + "=" + URLEncoder.encode(status,"UTF-8")+"&"+
                        URLEncoder.encode("orderno","UTF-8") + "=" + URLEncoder.encode(orderno,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Status Successfully Updated...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("response")){
            String reqno = params[1];
            String myresponse = params[2];
            String staname = params[3];
            try {
                URL url = new URL(response_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("reqno","UTF-8") + "=" + URLEncoder.encode(reqno,"UTF-8")+"&"+
                        URLEncoder.encode("myresponse","UTF-8") + "=" + URLEncoder.encode(myresponse,"UTF-8")+"&"+
                        URLEncoder.encode("staname","UTF-8") + "=" + URLEncoder.encode(staname,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Respond Successful...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("rating")){
            String rate = params[1];
            String orderno = params[2];
            try {
                URL url = new URL(rating_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("rate","UTF-8") + "=" + URLEncoder.encode(rate,"UTF-8")+"&"+
                        URLEncoder.encode("orderno","UTF-8") + "=" + URLEncoder.encode(orderno,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Service Rated Successfully...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("getrating")) {
            String orderno = params[1];
            try {
                URL url = new URL(getrating_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("orderno", "UTF-8") + "=" + URLEncoder.encode(orderno, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("text")) {
            String reqno = params[1];
            try {
                URL url = new URL(gettext_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("reqno", "UTF-8") + "=" + URLEncoder.encode(reqno, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login2")) {
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login2_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("login_name", "UTF-8") + "=" + URLEncoder.encode(login_name, "UTF-8") + "&" +
                        URLEncoder.encode("login_pass", "UTF-8") + "=" + URLEncoder.encode(login_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login")){
                String login_name = params[1];
                String login_pass = params[2];
                String resname = params[3];
                try {
                    URL url = new URL(login_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String data = URLEncoder.encode("login_name","UTF-8") + "=" + URLEncoder.encode(login_name,"UTF-8") + "&" +
//                            URLEncoder.encode("resname","UTF-8") + "=" + URLEncoder.encode(resname,"UTF-8") + "&" +
                            URLEncoder.encode("login_pass","UTF-8") + "=" + URLEncoder.encode(login_pass,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                    String response = "";
                    String line = "";
                    while ((line = bufferedReader.readLine())!=null){
                        response+=line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return response;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @SuppressLint("WrongThread")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(result.contains("Invalid")){
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.equals("Respond Successful...")){
            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
//            GlobalVariable2.myreqtext.setText(result);
            ctx.startActivity(new Intent(ctx, RequestToOrder.class));
        }
        else if(result.contains("Requesting")){
            GlobalVariable2.myreqtext.setText(result);
//            ctx.startActivity(new Intent(ctx, CustomerActivity.class));
//            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
        }
        else if(result.contains("Updated")){
//            GlobalVariable2.myRating.setText(result);
//            ctx.startActivity(new Intent(ctx, CustomerActivity.class));
            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
        }
        else if(result.contains("Rating")){
            GlobalVariable2.myRating.setText(result);
//            ctx.startActivity(new Intent(ctx, CustomerActivity.class));
//            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
        }
        else if(result.contains("Rated")){
            ctx.startActivity(new Intent(ctx, CustomerActivity.class));
            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
        }
        else if(result.equals("Request Successful...")){
            Toast.makeText(ctx,result,Toast.LENGTH_SHORT).show();
        }
        else if(result.equals("Status Successfully Updated...")){
            ctx.startActivity(new Intent(ctx, AllOrders.class));
            Toast.makeText(ctx,"The order is "+ result,Toast.LENGTH_SHORT).show();
        }
        else if(result.equals("Restaurant Registration Successful...")){
            ctx.startActivity(new Intent(ctx, StaffResActivity.class));
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.equals("Customer Registration Successful...")){
            ctx.startActivity(new Intent(ctx, LoginActivity.class));
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.equals("Staff Registration Successful...")) {
            ctx.startActivity(new Intent(ctx, StalogActivity.class));
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.contains("Customer")){
            ctx.startActivity(new Intent(ctx, RequestOrder.class));
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.contains("Staff")){
            ctx.startActivity(new Intent(ctx, OrderActivity.class));
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.contains("Restaurant")){
            ctx.startActivity(new Intent(ctx, StalogActivity.class));
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else if(result.contains("Order")){
//            ctx.startActivity(new Intent(ctx, OrderActivity.class));
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        }
        else{
            alertDialog.setTitle(result);
            alertDialog.show();

        }
    }
}
