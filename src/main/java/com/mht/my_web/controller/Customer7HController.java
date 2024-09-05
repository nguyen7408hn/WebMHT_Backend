package com.mht.my_web.controller;

import com.mht.my_web.dto.request.customerCreationRequest;
import com.mht.my_web.entity.Customer7H;
import com.mht.my_web.service.Customer7HService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customers7H")
public class Customer7HController {
    @Autowired
    private Customer7HService Customer7HService;

    @PostMapping
    Customer7H createCustomer(@RequestBody customerCreationRequest request) {
        return Customer7HService.createCustomer(request);
    }

    @GetMapping
    List<Customer7H> getCustomers() {
        return Customer7HService.getCustomers();
    }

    @PutMapping("/{id}")
    public Customer7H updateCustomer(@PathVariable Long id, @RequestBody customerCreationRequest request) {
        return Customer7HService.updateCustomer(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        Customer7HService.deleteCustomer(id);
    }
}
