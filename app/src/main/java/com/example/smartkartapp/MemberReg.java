package com.example.smartkartapp;

public class MemberReg {

    String username, password, phone;
    String id;
    public MemberReg(){

    }
    public MemberReg(String id, String username, String password, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }
}
