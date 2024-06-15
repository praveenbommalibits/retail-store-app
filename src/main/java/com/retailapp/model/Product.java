package com.retailapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Product {
    private String productId;
    private String name;
    private double price;
    private boolean isGrocery;
}
