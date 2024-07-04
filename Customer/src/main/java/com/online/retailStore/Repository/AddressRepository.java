package com.online.retailStore.Repository;

import com.online.retailStore.Models.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<CustomerAddress,Integer> {
}
