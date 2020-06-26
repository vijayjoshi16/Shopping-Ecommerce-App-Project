package com.example.smartkartapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class StaffHomePage extends AppCompatActivity {
    Button acOrd,currentOrderStatus;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home_page);
        final String currentStaffName=getIntent().getStringExtra("STAFFNAME");
        final String currentStaffPassword=getIntent().getStringExtra("STAFFPASSWORD");
        Toast.makeText(this,"Welcome, "+currentStaffName+"!",Toast.LENGTH_SHORT).show();

        acOrd=(Button)findViewById(R.id.accpet_orders);
        currentOrderStatus=(Button)findViewById(R.id.current_order_status);
        acOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StaffHomePage.this,AcceptOrders.class);
                i.putExtra("STAFFNAME",currentStaffName);
                i.putExtra("STAFFPASSWORD",currentStaffPassword);
                startActivity(i);
            }
        });

        currentOrderStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StaffHomePage.this,CurrentOrderStatus.class);
                i.putExtra("STAFFNAME",currentStaffName);
                i.putExtra("STAFFPASSWORD",currentStaffPassword);
                startActivity(i);
            }
        });

    }
    public void onBackPressed(){
        startActivity(new Intent(StaffHomePage.this,StaffLogin.class));
    }
    public void show(){
        Toast.makeText(this,"Accept a delivery in order to check its status",Toast.LENGTH_SHORT).show();
    }
}
