package com.example.retailStore.Repository;

import com.example.retailStore.Models.Order;
import com.example.retailStore.uiResponse.DataException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order addOrder(Order order) throws DataException;

    String deleteOrder(int orderId) throws DataException;

    Order updateOrder(Order orderId) throws DataException;

    Order getOrder(int orderId) throws DataException;
}
