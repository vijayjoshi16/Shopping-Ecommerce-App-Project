package com.example.smartkartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {
    EditText etname,etphone,etpass;
    Button register;
    static DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        databaseUsers= FirebaseDatabase.getInstance().getReference("memberReg");
        register=(Button)findViewById(R.id.btnregister);
        etname=(EditText)findViewById(R.id.etName);
        etphone=(EditText)findViewById(R.id.etPhone);
        etpass=(EditText)findViewById(R.id.etPassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg();
            }
        });
    }
    public void reg(){
        String name=etname.getText().toString();
        String phone=etphone.getText().toString();
        String password=etpass.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Please write your name",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(phone)){
            Toast.makeText(this,"Please write your phone no",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please write your password",Toast.LENGTH_SHORT).show();
        }else{
            String id=databaseUsers.push().getKey();
            MemberReg memberReg=new MemberReg(id,name,password,phone);
            databaseUsers.child(id).setValue(memberReg);
            Toast.makeText(this,"User registered",Toast.LENGTH_SHORT).show();
        }
    }
    public static void getuser(){
        databaseUsers=FirebaseDatabase.getInstance().getReference("memberReg");
    }
}
