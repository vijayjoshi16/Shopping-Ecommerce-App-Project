package com.example.smartkartapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddStock extends AppCompatActivity {
    public static DatabaseReference databaseStocks;
    EditText itemId,addQuantity;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);
        itemId=findViewById(R.id.etId);
        addQuantity=findViewById(R.id.etAdd);
        btnUpdate=findViewById(R.id.btnUpdateStock);
        databaseStocks= FirebaseDatabase.getInstance().getReference("stocksReg");
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty((itemId.getText()).toString()))
                   itemIdNotEntered();
                else if(TextUtils.isEmpty((addQuantity.getText()).toString()))
                    quantityNotEntered();
                else{
                    databaseStocks.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            int tmp=0;
                            for(DataSnapshot stockSnapshot:dataSnapshot.getChildren()){
                                StockReg stockReg=stockSnapshot.getValue(StockReg.class);
                                int id=stockReg.getItem_id();
                                if(id==Integer.valueOf(String.valueOf(itemId.getText()))){
                                    int curr=stockReg.getCurrentStockAvailaible()+Integer.parseInt(addQuantity.getText().toString());
                                    System.out.println(Integer.parseInt(addQuantity.getText().toString()));
                                    databaseStocks.child(stockReg.getId()).child("currentStockAvailaible").setValue(curr);
                                    tmp=1;
                                    showSuccess();
                                    Intent intent=new Intent(AddStock.this,AdminHomePage.class);
                                    intent.putExtra("CALLINGACTIVITY","AddStock");
                                    startActivity(intent);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    break;
                                }
                            }
                            if(tmp==1)
                                return;
                            if(tmp==0){
                               invalidItemId();
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
    public void itemIdNotEntered(){
        Toast.makeText(this,"Please Enter Item Id",Toast.LENGTH_SHORT).show();
    }

    public void quantityNotEntered(){
        Toast.makeText(this,"Please Enter Quantity to add",Toast.LENGTH_SHORT).show();
    }

    public void invalidItemId(){
        Toast.makeText(this,"Invalid item id",Toast.LENGTH_SHORT).show();
    }

    public void showSuccess() {
        Toast.makeText(this,"Stock Updated Successfully",Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed(){
        Intent intent=new Intent(AddStock.this,AdminHomePage.class);
        intent.putExtra("CALLINGACTIVITY","AddStock1");
        startActivity(intent);
    }

    public static void getStocks(){
        databaseStocks= FirebaseDatabase.getInstance().getReference("stocksReg");
    }

    public void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
