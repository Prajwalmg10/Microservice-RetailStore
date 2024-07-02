package com.example.retailStore.Repository;

import com.example.retailStore.Models.Customer;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByCustomerEmail(String email);
}
