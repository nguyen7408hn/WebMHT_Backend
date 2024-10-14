package com.mht.my_web.service;

import com.mht.my_web.dto.request.customerCreationRequest;
import com.mht.my_web.entity.Customer9H;
import com.mht.my_web.repository.Customer9HRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.mht.my_web.exception.ResourceNotFoundException;

@Service
public class Customer9HService {

    @Autowired
    private Customer9HRepository customer9HRepository;

    public Customer9H createCustomer(customerCreationRequest request) {
        // Tạo đối tượng Customer9H từ request
        Customer9H customer = new Customer9H();
        customer.setSdt(request.getSdt());
        customer.setSove(request.getSove());
        customer.setNoidon(request.getNoidon());
        customer.setNoidi(request.getNoidi());
        customer.setGhichu(request.getGhichu());
        // Lưu customer vào cơ sở dữ liệu
        return customer9HRepository.save(customer);
    }

    public List<Customer9H> getCustomers() {
        // Lấy danh sách tất cả khách hàng từ cơ sở dữ liệu
        return customer9HRepository.findAll();
    }

    public Customer9H getCustomer(Long id) {
        return customer9HRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    public Customer9H updateCustomer(Long id, customerCreationRequest request) {
        Optional<Customer9H> existingCustomer = customer9HRepository.findById(id);

        if (existingCustomer.isPresent()) {
            Customer9H customer = existingCustomer.get();
            // Update fields
            customer.setSdt(request.getSdt());
            customer.setSove(request.getSove());
            customer.setNoidon(request.getNoidon());
            customer.setNoidi(request.getNoidi());
            customer.setGhichu(request.getGhichu());
            return customer9HRepository.save(customer);
        } else {
            throw new RuntimeException("Customer9H not found with id: " + id);
        }
    }

    public void deleteCustomer(Long id) {
        if (customer9HRepository.existsById(id)) {
            customer9HRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Customer9H not found with id: " + id);
        }
    }

    public void deleteAllCustomers() {
        customer9HRepository.deleteAll();
    }
}
