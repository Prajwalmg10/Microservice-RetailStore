package com.example.retailStore.Repository;

import com.example.retailStore.Models.Cart;
import com.example.retailStore.uiResponse.DataException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    Cart createCart(Cart cart) throws DataException;

    String deleteCart(int cartId) throws DataException;

    Cart UpdateCart(Cart cartId) throws DataException;

    Cart getCart(int cartId) throws DataException;
}
