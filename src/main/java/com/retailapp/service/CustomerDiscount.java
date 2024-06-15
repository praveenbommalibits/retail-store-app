package com.retailapp.service;

import com.retailapp.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CustomerDiscount implements Discount {
    private int yearsAsCustomer;

    @Override
    public double calculateDiscount(Product product) {
        if (product.isGrocery()) {
            return 0;
        }
        // Applying 5% discount if customer tenure is over 2 years
        if (yearsAsCustomer >= 2) {
            return product.getPrice() * 0.05;
        }
        return 0;
    }

    @Override
    public void setCustomerTenure(int customerTenure) {
        this.yearsAsCustomer = customerTenure;
    }
}
