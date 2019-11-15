package com.example.sub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    public Button getreport_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getreport_btn=(Button)findViewById(R.id.getreport_btn);
        final Intent intent;
        intent=new Intent(this,MainActivity.class);
        getreport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag=1;
                intent.putExtra("flag",flag);
                startActivity(intent);



            }
        });
    }
}
