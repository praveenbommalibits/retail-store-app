package com.retailapp.service;

import com.retailapp.model.Product;

public interface Discount {
    double calculateDiscount(Product product);

    default void setCustomerTenure(int customerTenure) {
        // Default implementation does nothing; override in classes that need customer tenure
    }
}
