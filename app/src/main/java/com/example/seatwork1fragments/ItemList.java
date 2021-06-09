package com.example.seatwork1fragments;

public class ItemList {
    private String itemCode;
    private String item_desc;
    private String price;
    private String qty;

    public ItemList(String itemCode, String item_desc, String price, String qty) {
        this.itemCode = itemCode;
        this.item_desc = item_desc;
        this.price = price;
        this.qty = qty;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
