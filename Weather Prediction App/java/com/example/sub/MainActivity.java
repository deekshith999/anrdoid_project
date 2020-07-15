package com.example.sub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //public Button getreport_btn;
    public static TextView report_tv;
    public static TextView city_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getreport_btn=(Button)findViewById(R.id.getreport_btn);
        report_tv=(TextView)findViewById(R.id.report_tv);
        city_tv=(TextView)findViewById(R.id.city_tv);
//        getreport_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
       // Intent intent=new Intent(this,Main2Activity.class);
        int flag1=0;
        Intent intent=getIntent();
        flag1=intent.getIntExtra("flag",0);
        if (flag1==1)
        {
            FetchData fd =new FetchData();
                fd.execute();
        }

      //  FetchData fd =new FetchData();
//                fd.execute();
    }



}



