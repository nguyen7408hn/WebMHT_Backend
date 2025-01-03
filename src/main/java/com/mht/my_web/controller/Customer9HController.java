package com.mht.my_web.controller;

import com.mht.my_web.dto.request.customerCreationRequest;
import com.mht.my_web.entity.Customer9H;
import com.mht.my_web.service.Customer9HService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/Customers9H")
public class Customer9HController {
    @Autowired
    private Customer9HService Customer9HService;

    @PostMapping
    Customer9H createCustomer(@RequestBody customerCreationRequest request) {
        return Customer9HService.createCustomer(request);
    }

    @GetMapping
    List<Customer9H> getCustomers() {
        return Customer9HService.getCustomers();
    }

    @GetMapping("/{id}")
    Customer9H getCustomer(@PathVariable Long id) {
        return Customer9HService.getCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer9H updateCustomer(@PathVariable Long id, @RequestBody customerCreationRequest request) {
        return Customer9HService.updateCustomer(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        Customer9HService.deleteCustomer(id);
    }

    @DeleteMapping("/customers")
    public ResponseEntity<Void> deleteAllCustomers() {
        Customer9HService.deleteAllCustomers();
        return ResponseEntity.noContent().build();
    }
}
