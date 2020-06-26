package com.example.smartkartapp;

public class DeliverOrder {
    String name,phone,id,address,orderDetails,deliveryStaffName,price;

    public  DeliverOrder(){}

    public DeliverOrder(String name, String phone, String id, String address, String orderDetails,String deliveryStaffName,String price) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.address = address;
        this.orderDetails = orderDetails;
        this.deliveryStaffName=deliveryStaffName;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public String getDeliveryStaffName() { return deliveryStaffName; }

    public String getPrice(){ return price;}
}


