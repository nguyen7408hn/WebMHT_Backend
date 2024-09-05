package com.mht.my_web.service;

import com.mht.my_web.dto.request.customerCreationRequest;
import com.mht.my_web.entity.Customer1H;
import com.mht.my_web.repository.Customer1HRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.mht.my_web.exception.ResourceNotFoundException;

@Service
public class Customer1HService {

    @Autowired
    private Customer1HRepository customer1HRepository;

    public Customer1H createCustomer(customerCreationRequest request) {
        // Tạo đối tượng Customer1H từ request
        Customer1H customer = new Customer1H();
        customer.setSdt(request.getSdt());
        customer.setSove(request.getSove());
        customer.setNoidon(request.getNoidon());
        customer.setNoidi(request.getNoidi());

        // Lưu customer vào cơ sở dữ liệu
        return customer1HRepository.save(customer);
    }

    public List<Customer1H> getCustomers() {
        // Lấy danh sách tất cả khách hàng từ cơ sở dữ liệu
        return customer1HRepository.findAll();
    }

    public Customer1H updateCustomer(Long id, customerCreationRequest request) {
        Optional<Customer1H> existingCustomer = customer1HRepository.findById(id);

        if (existingCustomer.isPresent()) {
            Customer1H customer = existingCustomer.get();
            // Update fields
            customer.setSdt(request.getSdt());
            customer.setSove(request.getSove());
            customer.setNoidon(request.getNoidon());
            customer.setNoidi(request.getNoidi());
            return customer1HRepository.save(customer);
        } else {
            throw new RuntimeException("Customer1H not found with id: " + id);
        }
    }

    public void deleteCustomer(Long id) {
        if (customer1HRepository.existsById(id)) {
            customer1HRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Customer1H not found with id: " + id);
        }
    }
}
