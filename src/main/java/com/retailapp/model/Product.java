package com.retailapp.model;

public class Product {
    private String productId;
    private String name;
    private double price;
    private boolean isGrocery;

    public Product(String productId, String name, double price, boolean isGrocery) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.isGrocery = isGrocery;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isGrocery() {
        return isGrocery;
    }


}
