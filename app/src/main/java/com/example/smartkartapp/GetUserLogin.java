package com.example.smartkartapp;

public class GetUserLogin {
    String uname,uphone,id;
            public GetUserLogin(){ }

    public GetUserLogin(String uname, String uphone, String id) {
        this.id = id;
        this.uname = uname;
        this.uphone = uphone;
    }

    public String getUname() {
        return uname;
    }

    public String getUphone() {
        return uphone;
    }

    public String getId() {
        return id;
    }
}
