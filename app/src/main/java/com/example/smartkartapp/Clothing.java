package com.example.smartkartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Clothing extends AppCompatActivity {
    Button men,women;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
        men=findViewById(R.id.btMen);
        women=findViewById(R.id.btWomen);
        final String sna=getIntent().getStringExtra("NAME");
        final String sph=getIntent().getStringExtra("PHONE");
        final String spa=getIntent().getStringExtra("PASSWORD");
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Clothing.this,MensClothing.class);
                intent.putExtra("NAME",sna);
                intent.putExtra("PHONE",sph);
                intent.putExtra("PASSWORD",spa);
                startActivity(intent);
            }
        });
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Clothing.this,WomensClothing.class);
                intent.putExtra("NAME",sna);
                intent.putExtra("PHONE",sph);
                intent.putExtra("PASSWORD",spa);
                startActivity(intent);
            }
        });

    }
    public void onBackPressed(){
        final String sna=getIntent().getStringExtra("NAME");
        final String sph=getIntent().getStringExtra("PHONE");
        final String spa=getIntent().getStringExtra("PASSWORD");
        Intent intent=new Intent(Clothing.this,HomePageActivity.class);
        intent.putExtra("NAME",sna);
        intent.putExtra("PHONE",sph);
        intent.putExtra("PASSWORD",spa);
        intent.putExtra("CALLINGACTIVITY","Division");
        startActivity(intent);
    }
}
