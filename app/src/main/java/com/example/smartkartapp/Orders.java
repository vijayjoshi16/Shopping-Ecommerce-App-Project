package com.example.smartkartapp;

public class Orders {
    String custname,custphone,custaddr,custpass;
    String spec;
    String id;
    int price;
    public  Orders(){

    }

    public Orders(String id,String spec,String custname,String custphone,String custaddr,String custpass,int price){
        this.id=id;
        this.spec=spec;
        this.custname=custname;
        this.custphone=custphone;
        this.custaddr=custaddr;
        this.custpass=custpass;
        this.price=price;
    }

    public String getSpec() {
        return spec;
    }

    public String getId() {
        return id;
    }

    public String getCustname() {
        return custname;
    }

    public String getCustphone() {
        return custphone;
    }

    public String getCustaddr() {
        return custaddr;
    }

    public String getCustpass() { return custpass; }

    public int getPrice(){
        return price;
    }
}
