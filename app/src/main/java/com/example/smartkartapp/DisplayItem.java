package com.example.smartkartapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class DisplayItem extends AppCompatActivity {
    ImageView imageView;
    TextView imageDetails,imagePrice;
    Button orderShownItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        imageView=findViewById(R.id.item_display);
        imageDetails=findViewById(R.id.item_details_display);
        imagePrice=findViewById(R.id.item_price_display);
        orderShownItem=findViewById(R.id.order_shown_item);
        imageView.setImageResource(getIntent().getIntExtra("image_id",00));
        imageDetails.setText(getIntent().getStringExtra("item_details"));
        imagePrice.setText(Integer.toString(getIntent().getIntExtra("item_price",00)));
        final String sna=getIntent().getStringExtra("NAME");
        final String sph=getIntent().getStringExtra("PHONE");
        final String spa=getIntent().getStringExtra("PASSWORD");
        final String ca=getIntent().getStringExtra("CALLING_ACTIVITY");
        final int img_id=getIntent().getIntExtra("image_id",00);
        final String item_details=getIntent().getStringExtra("item_details");
        final int item_price=getIntent().getIntExtra("item_price",00);
        AddStock.getStocks();
        AddStock.databaseStocks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot stockSnapshot:dataSnapshot.getChildren()){
                    StockReg stockReg=stockSnapshot.getValue(StockReg.class);
                    String item_det=stockReg.getItemName();
                    if(item_det.equals(item_details)){
                        if(stockReg.getCurrentStockAvailaible()==0){
                            orderShownItem.setEnabled(false);
                            orderShownItem.setText("CURRENTLY OUT OF STOCK");
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        orderShownItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DisplayItem.this,PlaceOrder.class);
                intent.putExtra("CUSTNAME",sna);
                intent.putExtra("CUSTPH",sph);
                intent.putExtra("CUSTPASS",spa);
                intent.putExtra("ITEMDET",imageDetails.getText());
                intent.putExtra("CALLING_ACTIVITY",ca);
                intent.putExtra("image_id",img_id);
                intent.putExtra("item_details",item_details);
                intent.putExtra("item_price",item_price);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed(){
        final String sna=getIntent().getStringExtra("NAME");
        final String sph=getIntent().getStringExtra("PHONE");
        final String spa=getIntent().getStringExtra("PASSWORD");
        final String ca=getIntent().getStringExtra("CALLING_ACTIVITY");
        if(ca.equals("Books")){
            Intent intent=new Intent(DisplayItem.this,Books.class);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            startActivity(intent);
        }else if(ca.equals("tShirts")){
            Intent intent=new Intent(DisplayItem.this,tShirts.class);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            startActivity(intent);
        }else if(ca.equals("Formals")){
            Intent intent=new Intent(DisplayItem.this,Formals.class);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            startActivity(intent);
        }else if(ca.equals("BottomWear")){
            Intent intent=new Intent(DisplayItem.this,BottomWear.class);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            startActivity(intent);
        }else if(ca.equals("Shoes")){
            Intent intent=new Intent(DisplayItem.this,Shoes.class);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            startActivity(intent);
        }else if(ca.equals("WomensClothing")){
            Intent intent=new Intent(DisplayItem.this,WomensClothing.class);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            startActivity(intent);
        }else if(ca.equals("Electronics")){
            Intent intent=new Intent(DisplayItem.this,Electronics.class);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            startActivity(intent);
        }else if(ca.equals("OtherItems")){
            Intent intent=new Intent(DisplayItem.this,OtherItems.class);
            intent.putExtra("NAME",sna);
            intent.putExtra("PHONE",sph);
            intent.putExtra("PASSWORD",spa);
            startActivity(intent);
        }
    }
}
