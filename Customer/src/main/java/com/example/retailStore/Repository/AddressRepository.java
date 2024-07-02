package com.example.retailStore.Repository;

import com.example.retailStore.Models.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<CustomerAddress,Integer> {
}
