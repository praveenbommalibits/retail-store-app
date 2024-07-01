package com.retailapp.controller;

import com.retailapp.model.Bill;
import com.retailapp.model.Product;
import com.retailapp.service.AffiliateDiscount;
import com.retailapp.service.CustomerDiscount;
import com.retailapp.service.Discount;
import com.retailapp.service.EmployeeDiscount;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private Map<String, Bill> bills = new HashMap<>();


    @PostMapping(value = "/calculateTotal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> calculateTotal(@RequestParam String discountType, @RequestParam int tenure, @RequestBody List<Product> products) {
        Discount discount = getDiscountStrategy(discountType);
        Bill bill = new Bill(discount);
        bill.setCustomerTenure(tenure);
        for (Product product : products) {
            bill.addProduct(product);
        }
        double totalPayableAmount = bill.calculateTotalPayableAmount();
        return ResponseEntity.ok(totalPayableAmount);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createBill(@RequestParam String discountType) {
        Discount discount = getDiscountStrategy(discountType);
        Bill bill = new Bill(discount);
        String billId = "bill-" + (bills.size() + 1);
        bills.put(billId, bill);
        return billId;
    }

    @PostMapping(value = "/{billId}/addProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> addProduct(@PathVariable String billId, @RequestBody Product product) {
        Bill bill = bills.get(billId);
        if (bill != null) {
            bill.addProduct(product);
            return ResponseEntity.ok(bill);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/{billId}/setCustomerTenure", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> setCustomerTenure(@PathVariable String billId, @RequestParam int tenure) {
        Bill bill = bills.get(billId);
        if (bill != null) {
            try {
                bill.setCustomerTenure(tenure);
                return ResponseEntity.ok(bill);
            } catch (UnsupportedOperationException e) {
                return ResponseEntity.badRequest().body(bill);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{billId}/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> calculateTotalPayableAmount(@PathVariable String billId) {
        Bill bill = bills.get(billId);
        if (bill != null) {
            return ResponseEntity.ok(bill.calculateTotalPayableAmount());
        }
        return ResponseEntity.notFound().build();
    }

    private Discount getDiscountStrategy(String discountType) {
        switch (discountType.toLowerCase()) {
            case "employee":
                return new EmployeeDiscount();
            case "affiliate":
                return new AffiliateDiscount();
            case "customer":
                return new CustomerDiscount();
            default:
                throw new IllegalArgumentException("Invalid discount type");
        }
    }
}
