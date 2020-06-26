package com.example.smartkartapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class tShirts extends AppCompatActivity {
    private RecyclerView recyclerView;
    int[] images={R.drawable.t1,R.drawable.t2,R.drawable.t3,R.drawable.t4,R.drawable.t5,R.drawable.t6};
    String details[]={"T-Shirt 1","T-Shirt 2","T-Shirt 3","T-Shirt 4","T-Shirt 5","T-Shirt 6"};
    int[] prices={699,1299,459,899,949,499};
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_shirts);
        recyclerView=findViewById(R.id.rvTShirts);
        final String sna=getIntent().getStringExtra("NAME");
        final String sph=getIntent().getStringExtra("PHONE");
        final String spa=getIntent().getStringExtra("PASSWORD");
        layoutManager=new GridLayoutManager(this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecyclerAdapter(images,details,prices,this,sna,sph,spa,"tShirts");
        recyclerView.setAdapter(adapter);
    }
    public void onBackPressed(){
        final String sna=getIntent().getStringExtra("NAME");
        final String sph=getIntent().getStringExtra("PHONE");
        final String spa=getIntent().getStringExtra("PASSWORD");
        Intent intent=new Intent(tShirts.this,MensClothing.class);
        intent.putExtra("NAME",sna);
        intent.putExtra("PHONE",sph);
        intent.putExtra("PASSWORD",spa);
        startActivity(intent);
    }
}
