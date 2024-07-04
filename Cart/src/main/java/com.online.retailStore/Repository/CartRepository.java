package com.online.retailStore.Repository;


import com.online.retailStore.Models.Cart;
import com.online.retailStore.uiResponse.DataException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
