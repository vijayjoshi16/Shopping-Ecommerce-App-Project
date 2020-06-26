package com.example.smartkartapp;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity {
Button clothing,electronics,books,otherItems;
    private AppBarConfiguration mAppBarConfiguration;
    static DatabaseReference databaseOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        clothing=findViewById(R.id.clothing);
        electronics=findViewById(R.id.electronics);
        books=findViewById(R.id.books);
        otherItems=findViewById(R.id.otherItems);
        final String sna=getIntent().getStringExtra("NAME");
        final String sph=getIntent().getStringExtra("PHONE");
        final String spa=getIntent().getStringExtra("PASSWORD");
        final String ca=getIntent().getStringExtra("CALLINGACTIVITY");
        if(ca.equals("LoginPage"))
            Toast.makeText(this,"Hello ,"+sna+"!",Toast.LENGTH_SHORT).show();
        else if(ca.equals("PlaceOrder"))
            Toast.makeText(this,"Order Placed Successfully!",Toast.LENGTH_LONG).show();
        clothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePageActivity.this,Clothing.class);
                intent.putExtra("NAME",sna);
                intent.putExtra("PHONE",sph);
                intent.putExtra("PASSWORD",spa);
                startActivity(intent);
            }
        });
        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePageActivity.this,Electronics.class);
                intent.putExtra("NAME",sna);
                intent.putExtra("PHONE",sph);
                intent.putExtra("PASSWORD",spa);
                startActivity(intent);
            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePageActivity.this,Books.class);
                intent.putExtra("NAME",sna);
                intent.putExtra("PHONE",sph);
                intent.putExtra("PASSWORD",spa);
                startActivity(intent);
            }
        });
        otherItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePageActivity.this,OtherItems.class);
                intent.putExtra("NAME",sna);
                intent.putExtra("PHONE",sph);
                intent.putExtra("PASSWORD",spa);
                startActivity(intent);
            }
        });
        databaseOrders=FirebaseDatabase.getInstance().getReference("orders");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void onBackPressed(){
        startActivity(new Intent(HomePageActivity.this,LoginPage.class));
    }
    public static void getOrder(){
        databaseOrders=FirebaseDatabase.getInstance().getReference("orders");
    }
}
