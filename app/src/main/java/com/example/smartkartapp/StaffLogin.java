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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class StaffLogin extends AppCompatActivity {
    EditText stfname,stfpass;
    TextView stfstatus;
    Button stflogin;
    String sna,spa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);
        stfname = (EditText) findViewById(R.id.stfname);
        stfpass = (EditText) findViewById(R.id.stfpass);
        stfstatus = (TextView) findViewById(R.id.stfstatus);
        stflogin = (Button) findViewById(R.id.stflogin);
        stfstatus.setText("");
        stflogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddStaff.getStaff();
                sna=stfname.getText().toString();
                spa=stfpass.getText().toString();
                if(TextUtils.isEmpty(sna))
                    stfstatus.setText("Please enter your name");
                else if(TextUtils.isEmpty(spa))
                    stfstatus.setText("Please enter your password");
                else{
                    AddStaff.databaseStaff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            int success=0;
                            for(DataSnapshot staffSnapshot:dataSnapshot.getChildren()) {
                                StaffReg staffReg = staffSnapshot.getValue(StaffReg.class);
                                final String dpn = staffReg.getStaffname();
                                final String dpa = staffReg.getPassword();
                                if (dpn.equals(sna) && dpa.equals(spa)) {
                                    AcceptOrders.getDelivery();
                                    AcceptOrders.databaseOngoingDelivery.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            int is_busy=0;
                                            for(DataSnapshot deliverySnapshot:dataSnapshot.getChildren()){
                                                DeliverOrder deliverOrder=deliverySnapshot.getValue(DeliverOrder.class);
                                                if(deliverOrder.getDeliveryStaffName().equals(dpn)){
                                                    Intent intent = new Intent(StaffLogin.this,CurrentOrderStatus.class);
                                                    intent.putExtra("STAFFNAME",dpa);
                                                    intent.putExtra("STAFFPASSWORD",dpa);
                                                    startActivity(intent);
                                                    is_busy=1;
                                                }
                                            }
                                            if(is_busy==0){
                                                Intent intent = new Intent(StaffLogin.this,AcceptOrders.class);
                                                intent.putExtra("STAFFNAME",dpa);
                                                intent.putExtra("STAFFPASSWORD",dpa);
                                                startActivity(intent);
                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    success=1;
                                }
                            }
                                if(success==0)
                                stfstatus.setText("Invalid Credentials");
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
    public void onBackPressed(){
        startActivity(new Intent(StaffLogin.this,RegLogChoice.class));
    }
}
