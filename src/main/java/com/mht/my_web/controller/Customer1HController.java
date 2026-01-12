package com.mht.my_web.controller;

import com.mht.my_web.dto.request.customerCreationRequest;
import com.mht.my_web.entity.Customer1H;
import com.mht.my_web.service.Customer1HService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/Customers1H")
public class Customer1HController {
    @Autowired
    private Customer1HService Customer1HService;

    @PostMapping
    Customer1H createCustomer(@RequestBody customerCreationRequest request) {
        return Customer1HService.createCustomer(request);
    }

    @GetMapping
    List<Customer1H> getCustomers() {
        return Customer1HService.getCustomers();
    }

    @GetMapping("/{id}")
    Customer1H getCustomer(@PathVariable Long id) {
        return Customer1HService.getCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer1H updateCustomer(@PathVariable Long id, @RequestBody customerCreationRequest request) {
        return Customer1HService.updateCustomer(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        Customer1HService.deleteCustomer(id);
    }

    @DeleteMapping("/customers")
    public ResponseEntity<Void> deleteAllCustomers() {
        Customer1HService.deleteAllCustomers();
        return ResponseEntity.noContent().build();
    }
}
