package com.online.retailStore.Services.Implementation;

import com.online.retailStore.Models.Order;
import com.online.retailStore.Repository.OrderRepository;
import com.online.retailStore.Services.OrderServices;
import com.online.retailStore.Util.NullEmptyUtils;
import com.online.retailStore.Util.StringConstants;
import com.online.retailStore.Util.ValidationHelper;
import com.online.retailStore.uiResponse.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) throws DataException {
        ValidationHelper.validateOrder(order);
        try{
            return orderRepository.save(order);
        }catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String deleteOrder(int orderId) throws DataException {
        Order order=getOrder(orderId);
        if(NullEmptyUtils.isNull(order)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID,HttpStatus.BAD_REQUEST);
        }
        return StringConstants.SUCCESS;
    }

    @Override
    public Order updateOrder(Order order) throws DataException {
        ValidationHelper.validateOrder(order);
        if(NullEmptyUtils.isNullorEmpty(order.getOrderId())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_ORDER_ID,HttpStatus.BAD_REQUEST);
        }
        try{
            return orderRepository.save(order);
        }catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Order getOrder(int orderId) throws DataException {
        if(NullEmptyUtils.isNullorEmpty(orderId)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID,HttpStatus.BAD_REQUEST);
        }
        return orderRepository.findById(orderId).get();
    }
}
