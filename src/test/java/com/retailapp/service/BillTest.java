package com.retailapp.service;

import com.retailapp.model.Bill;
import com.retailapp.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillTest {

    @Test
    public void testEmployeeDiscount() {
        Bill bill = new Bill(new EmployeeDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        bill.addProduct(product);
        assertEquals(650, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    public void testAffiliateDiscount() {
        Bill bill = new Bill(new AffiliateDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        bill.addProduct(product);
        assertEquals(850, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    public void testCustomerDiscount() {
        Bill bill = new Bill(new CustomerDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        bill.addProduct(product);
        assertEquals(900, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    public void testGroceryNoDiscount() {
        Bill bill = new Bill(new EmployeeDiscount());
        Product product = new Product("1", "Milk", 200, true);
        bill.addProduct(product);
        assertEquals(190, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    public void testFlatDiscount() {
        Bill bill = new Bill(new EmployeeDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        Product product2 = new Product("2", "Phone", 500, false);
        bill.addProduct(product);
        bill.addProduct(product2);
        assertEquals(975, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    public void testMultipleProducts() {
        Bill bill = new Bill(new AffiliateDiscount());
        Product product1 = new Product("1", "Laptop", 1000, false);
        Product product2 = new Product("2", "Phone", 500, false);
        Product product3 = new Product("3", "Milk", 200, true);
        bill.addProduct(product1);
        bill.addProduct(product2);
        bill.addProduct(product3);
        assertEquals(1465, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    public void testCustomerGroceryNoDiscount() {
        Bill bill = new Bill(new CustomerDiscount());
        Product product = new Product("1", "Milk", 200, true);
        bill.addProduct(product);
        assertEquals(190, bill.calculateTotalPayableAmount(), 0.01);
    }
}
