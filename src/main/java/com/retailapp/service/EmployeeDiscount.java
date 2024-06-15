package com.retailapp.service;


import com.retailapp.model.Product;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDiscount implements Discount {
    @Override
    public double calculateDiscount(Product product) {
        if (product.isGrocery()) {
            return 0;
        }
        return product.getPrice() * 0.30;
    }
}
