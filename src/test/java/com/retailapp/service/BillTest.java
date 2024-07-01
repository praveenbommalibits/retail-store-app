package com.retailapp.service;

import com.retailapp.model.Bill;
import com.retailapp.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BillTest {

    @Test
    void testEmployeeDiscount() {
        Bill bill = new Bill(new EmployeeDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        bill.addProduct(product);
        assertEquals(650, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    void testAffiliateDiscount() {
        Bill bill = new Bill(new AffiliateDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        bill.addProduct(product);
        assertEquals(850, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    void testCustomerDiscountWithTenure() {
        Bill bill = new Bill(new CustomerDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        bill.addProduct(product);
        bill.setCustomerTenure(3); // Set customer tenure as 3 years
        assertEquals(900, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    void testCustomerDiscountWithoutTenure() {
        Bill bill = new Bill(new CustomerDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        bill.addProduct(product);
        bill.setCustomerTenure(1); // Set customer tenure as 1 year
        assertEquals(950, bill.calculateTotalPayableAmount(), 0.01);
    }


    @Test
    void testGroceryNoDiscount() {
        Bill bill = new Bill(new EmployeeDiscount());
        Product product = new Product("1", "Milk", 200, true);
        bill.addProduct(product);
        assertEquals(190, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    void testFlatDiscount() {
        Bill bill = new Bill(new EmployeeDiscount());
        Product product = new Product("1", "Laptop", 1000, false);
        Product product2 = new Product("2", "Phone", 500, false);
        bill.addProduct(product);
        bill.addProduct(product2);
        assertEquals(975, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    void testMultipleProducts() {
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
    void testCustomerGroceryNoDiscount() {
        Bill bill = new Bill(new CustomerDiscount());
        Product product = new Product("1", "Milk", 200, true);
        bill.addProduct(product);
        assertEquals(190, bill.calculateTotalPayableAmount(), 0.01);
    }

    @Test
    void testBusinessFlowWithProductModification() {
        Bill bill = new Bill(new EmployeeDiscount());
        Product product = new Product("1", "Tablet", 300, false);
        bill.addProduct(product);

        product.setName("Tablet Pro");
        product.setPrice(400);

        assertEquals(260, bill.calculateTotalPayableAmount(), 0.01);
    }


    @Test
    void testSetCustomerTenureWithNonCustomerDiscount() {
        Bill bill = new Bill(new EmployeeDiscount()); // Assuming EmployeeDiscount does not require customer tenure
        //UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            bill.setCustomerTenure(2);
        //});

        }
}
