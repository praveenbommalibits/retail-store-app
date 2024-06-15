package com.retailapp.service;

import com.retailapp.model.Product;

public interface Discount {
    double calculateDiscount(Product product);
}
