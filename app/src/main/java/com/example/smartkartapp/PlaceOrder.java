package com.example.smartkartapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlaceOrder extends AppCompatActivity {
TextView cname,cphone,ordspec,ordError,ordprice;
EditText addr;
Button plord;
static DatabaseReference databaseOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        cname=(TextView)findViewById(R.id.custname);
        cphone=(TextView)findViewById(R.id.custphone);
        ordspec=(TextView)findViewById(R.id.itemdet);
        ordprice=findViewById(R.id.itemprice);
        addr=(EditText)findViewById(R.id.etadd);
        plord=(Button)findViewById(R.id.btnplord);
        ordError=(TextView)findViewById(R.id.ordError);
        ordError.setText("");
        databaseOrders= FirebaseDatabase.getInstance().getReference("orders");
        final String n=getIntent().getStringExtra("CUSTNAME");
        final String ph=getIntent().getStringExtra("CUSTPH");
        final String pa=getIntent().getStringExtra("CUSTPASS");
        final String it=getIntent().getStringExtra("ITEMDET");
        final int itp=getIntent().getIntExtra("item_price",00);
        cname.setText(n);
        cphone.setText(ph);
        ordspec.setText(it);
        ordprice.setText(Integer.toString(itp));
        plord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(addr.getText().toString())){
                    ordError.setText("Please enter your address");
                }else{
                    AddStock.getStocks();
                    AddStock.databaseStocks.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot stockSnapshot:dataSnapshot.getChildren()){
                                StockReg stockReg=stockSnapshot.getValue(StockReg.class);
                                if(stockReg.getItemName().equals(it)){
                                    int curr=stockReg.getCurrentStockAvailaible();
                                    curr--;
                                    AddStock.databaseStocks.child(stockReg.getId()).child("currentStockAvailaible").setValue(curr);
                                    String id=databaseOrders.push().getKey();
                                    Orders orders=new Orders(id,it,n,ph,addr.getText().toString(),pa,itp);
                                    databaseOrders.child(id).setValue(orders);
                                    show();
                                    Intent i=new Intent(PlaceOrder.this,HomePageActivity.class);
                                    i.putExtra("NAME",n);
                                    i.putExtra("PHONE",ph);
                                    i.putExtra("PASSWORD",pa);
                                    i.putExtra("CALLINGACTIVITY","PlaceOrder");
                                    startActivity(i);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    break;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });
    }
    public void show(){
        Toast.makeText(this,"Order placed successfully",Toast.LENGTH_SHORT).show();
    }

    public static void getOrder(){
        databaseOrders=FirebaseDatabase.getInstance().getReference("orders");
    }
    public void onBackPressed(){
        final String n=getIntent().getStringExtra("CUSTNAME");
        final String ph=getIntent().getStringExtra("CUSTPH");
        final String pa=getIntent().getStringExtra("CUSTPASS");
        final String ca=getIntent().getStringExtra("CALLING_ACTIVITY");
        final int img_id=getIntent().getIntExtra("image_id",00);
        final int img_price=getIntent().getIntExtra("item_price",00);
        final String item_details=getIntent().getStringExtra("item_details");
            Intent intent=new Intent(PlaceOrder.this,DisplayItem.class);
            intent.putExtra("NAME",n);
            intent.putExtra("PHONE",ph);
            intent.putExtra("PASSWORD",pa);
            intent.putExtra("CALLING_ACTIVITY",ca);
            intent.putExtra("image_id",img_id);
            intent.putExtra("item_details",item_details);
            intent.putExtra("item_price",img_price);
            startActivity(intent);
    }
}
