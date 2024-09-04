package com.mht.my_web.service;

import com.mht.my_web.dto.request.customerCreationRequest;
import com.mht.my_web.entity.Customer7H;
import com.mht.my_web.repository.Customer7HRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Customer7HService {

    @Autowired
    private Customer7HRepository customer7HRepository;

    public Customer7H createCustomer(customerCreationRequest request) {
        // Tạo đối tượng Customer7H từ request
        Customer7H customer = new Customer7H();
        customer.setSdt(request.getSdt());
        customer.setSove(request.getSove());
        customer.setNoidon(request.getNoidon());
        customer.setNoidi(request.getNoidi());

        // Lưu customer vào cơ sở dữ liệu
        return customer7HRepository.save(customer);
    }

    public List<Customer7H> getCustomers() {
        // Lấy danh sách tất cả khách hàng từ cơ sở dữ liệu
        return customer7HRepository.findAll();
    }

    public Customer7H updateCustomer(Long id, customerCreationRequest request) {
        Optional<Customer7H> existingCustomer = customer7HRepository.findById(id);

        if (existingCustomer.isPresent()) {
            Customer7H customer = existingCustomer.get();
            // Update fields
            customer.setSdt(request.getSdt());
            customer.setSove(request.getSove());
            customer.setNoidon(request.getNoidon());
            customer.setNoidi(request.getNoidi());
            return customer7HRepository.save(customer);
        } else {
            throw new RuntimeException("Customer7H not found with id: " + id);
        }
    }
}
