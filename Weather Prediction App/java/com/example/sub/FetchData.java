package com.example.sub;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.sub.MainActivity.city_tv;
import static com.example.sub.MainActivity.report_tv;


public class FetchData extends AsyncTask< Void,Void,Void> {
 public String res_data="";
 public  String city_name="";
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://api.myjson.com/bins/xiv0c");
            HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
            InputStream istream = httpconn.getInputStream();
            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(istream));
            String data = "";
            String temp = "";
            System.out.println("entered here");
            while (temp != null) {
                temp = br.readLine();
                data = data + temp;
                System.out.println(data+"\n");
            }


            JSONObject jobj1 = new JSONObject(data);
            JSONObject jobj2 = jobj1.getJSONObject("city");
            city_name =city_name+ jobj2.get("name").toString();
            System.out.println("\n\n\n\n\n"+city_name);
            System.out.println("city: " + city_name);

            JSONArray jarr1 = jobj1.getJSONArray("list");
            System.out.println(jarr1);
            System.out.println("jarr len =" + jarr1.length());
            for (int i = 0; i < jarr1.length(); i++) {

                int day1=i+1;
                JSONObject jobj3 = jarr1.getJSONObject(i);
                JSONObject jobj4 = jobj3.getJSONObject("temp");
                String day = jobj4.getString("day");
                String night = jobj4.getString("night");
                String eve = jobj4.getString("eve");
                String morn = jobj4.getString("morn");

                String min = jobj4.getString("min");
                String max = jobj4.getString("max");


                res_data=res_data+"\nday "+day1+"\n\nday : " + day + "\n night : " + night + "\n eve : " + eve + "\n morn : " + morn + "\n min : " + min + "\n max : " + max+"\n--------";


            }


            //System.out.println(data);


        } catch (Exception e) {
            System.out.println("creating exception-----------------------------------");
            e.printStackTrace();
        }
return null;

    }



    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        report_tv.setText(res_data);
        city_tv.setText(city_name);
    }
}
