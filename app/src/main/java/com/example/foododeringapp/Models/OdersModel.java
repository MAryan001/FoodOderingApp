package com.example.foododeringapp.Models;

public class OdersModel {
    int OderImage;
    String soldItemName,price,oderNumber;

    public OdersModel() {
        OderImage = OderImage;
        this.soldItemName = soldItemName;
        this.price = price;
        this.oderNumber = oderNumber;
    }

    public int getOderImage() {
        return OderImage;
    }

    public void setOderImage(int oderImage) {
        OderImage = oderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOderNumber() {
        return oderNumber;
    }

    public void setOderNumber(String oderNumber) {
        this.oderNumber = oderNumber;
    }
}
