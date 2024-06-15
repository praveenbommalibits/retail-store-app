package com.retailapp.service;

import com.retailapp.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CustomerDiscount implements Discount {
    @Override
    public double calculateDiscount(Product product) {
        if (product.isGrocery()) {
            return 0;
        }
        return product.getPrice() * 0.05;
    }
}
