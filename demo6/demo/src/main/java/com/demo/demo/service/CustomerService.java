package com.demo.demo.service;


import com.demo.demo.dto.CustomerDTO;
import com.demo.demo.entity.Customer;
import com.demo.demo.repository.CustomerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<CustomerDTO> findById(Long id) {
        Customer  customer = customerRepository.findById(id).orElse(null);
        CustomerDTO customerDTO = new CustomerDTO();
        assert customer != null;
        customerDTO.setId(customer.getId());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setActive(customer.getActive());
        customerDTO.setFullName(customer.getFullName());
        customerDTO.setPassword(customer.getPassword());
        return Optional.of(customerDTO);
    }

    public Boolean create(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setUsername(customerDTO.getUsername());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        customer.setActive(customerDTO.getActive());
        customer.setFullName(customerDTO.getFullName());
        customer.setPassword(customerDTO.getPassword());
        try {
            customerRepository.save(customer);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Customer update(Long id, CustomerDTO updateDTO) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setUsername(updateDTO.getUsername());
                    customer.setEmail(updateDTO.getEmail());
                    customer.setAddress(updateDTO.getAddress());
                    customer.setPhone(updateDTO.getPhone());
                    customer.setActive(updateDTO.getActive());
                    customer.setFullName(updateDTO.getFullName());
                    customer.setPassword(updateDTO.getPassword());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
