package com.example.smartkartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegLogChoice extends AppCompatActivity {
    Button reg,log;
    TextView admlog,stflog,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_log_choice);
        reg=(Button)findViewById(R.id.btnreg);
        log=(Button)findViewById(R.id.btnlog);
        admlog=(TextView)findViewById(R.id.admlog);
        stflog=(TextView)findViewById(R.id.stflog);
        about=(TextView)findViewById(R.id.tvAbout);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegLogChoice.this,LoginPage.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegLogChoice.this,RegisterPage.class);
                startActivity(intent);
            }
        });
        admlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegLogChoice.this,AdminLogin.class));
            }
        });
        stflog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegLogChoice.this,StaffLogin.class));
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegLogChoice.this,About.class));
            }
        });
    }
    public void onBackPressed(){
     moveTaskToBack(true);
     android.os.Process.killProcess(android.os.Process.myPid());
     System.exit(1);
    }
}
