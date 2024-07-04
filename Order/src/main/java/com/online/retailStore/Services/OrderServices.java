package com.online.retailStore.Services;

import com.online.retailStore.Models.Order;
import com.online.retailStore.uiResponse.DataException;

public interface OrderServices {

    Order addOrder(Order order) throws DataException;

    String deleteOrder(int orderId) throws DataException;

    Order updateOrder(Order orderId) throws DataException;

    Order getOrder(int orderId) throws DataException;
}
