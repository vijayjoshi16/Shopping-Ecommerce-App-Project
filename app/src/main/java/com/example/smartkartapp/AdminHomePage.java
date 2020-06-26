package com.example.smartkartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminHomePage extends AppCompatActivity {
Button addStaff,addStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
        addStaff=findViewById(R.id.btn_add_staff);
        addStock=findViewById(R.id.btn_add_stock);
        String ca=getIntent().getStringExtra("CALLINGACTIVITY");
        if(ca.equals("AdminLogin"))
            Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();
        else if(ca.equals("AddStock"))
            Toast.makeText(this,"Stock Updated Successfully",Toast.LENGTH_LONG).show();
        addStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminHomePage.this,AddStaff.class));
            }
        });
        addStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminHomePage.this, AddStock.class));
            }
        });


    }
    public void onBackPressed(){
        startActivity(new Intent(AdminHomePage.this,AdminLogin.class));
    }
}
