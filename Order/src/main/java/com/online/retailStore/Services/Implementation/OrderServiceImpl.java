package com.online.retailStore.Services.Implementation;

import com.online.retailStore.Models.Order;
import com.online.retailStore.Services.OrderServices;
import com.online.retailStore.uiResponse.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderServices {
    @Override
    public Order addOrder(Order order) throws DataException {
        return null;
    }

    @Override
    public String deleteOrder(int orderId) throws DataException {
        return "";
    }

    @Override
    public Order updateOrder(Order orderId) throws DataException {
        return null;
    }

    @Override
    public Order getOrder(int orderId) throws DataException {
        return null;
    }
}
