package com.demo.demo.repository;

import com.demo.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CustomerRepository extends JpaRepository<Customer,Long> {
}
