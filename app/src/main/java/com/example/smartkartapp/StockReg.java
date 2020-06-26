package com.example.smartkartapp;

public class StockReg {
    String itemName,id;
    int item_id,currentStockAvailaible;
    public  StockReg(){

    }

    public StockReg(String itemName,String id, int item_id, int currentStockAvailaible) {
        this.itemName = itemName;
        this.id=id;
        this.item_id = item_id;
        this.currentStockAvailaible = currentStockAvailaible;
    }

    public String getItemName() {
        return itemName;
    }

    public String getId() {
        return id;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getCurrentStockAvailaible() {
        return currentStockAvailaible;
    }
}
