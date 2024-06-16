package com.retailapp.model;

import com.retailapp.service.CustomerDiscount;
import com.retailapp.service.Discount;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Product> products;
    private Discount discountStrategy;
    private Integer customerTenure;

    public Bill(Discount discountStrategy) {
        this.products = new ArrayList<>();
        this.discountStrategy = discountStrategy;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void setCustomerTenure(int customerTenure) {
        if (discountStrategy instanceof CustomerDiscount) {
            this.customerTenure = customerTenure;
            discountStrategy.setCustomerTenure(customerTenure);
        } else {
            throw new UnsupportedOperationException("Current discount strategy does not require customer tenure.");
        }
    }

    public double calculateTotalPayableAmount() {
        double total = 0;
        double discount = 0;

        for (Product product : products) {
            total += product.getPrice();
            discount += discountStrategy.calculateDiscount(product);
        }

        double flatDiscount = (int) (total / 100) * 5;
        return total - discount - flatDiscount;
    }
}
