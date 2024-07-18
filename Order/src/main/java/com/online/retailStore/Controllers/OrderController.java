package com.online.retailStore.Controllers;

import com.online.retailStore.Models.Order;
import com.online.retailStore.Services.OrderServices;
import com.online.retailStore.UiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/order")
public class OrderController extends AbstarctController{

    @Autowired
    private OrderServices orderServices;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        try {
            return  buildResponse(orderServices.addOrder(order));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody Order order){
        try {
            return  buildResponse(orderServices.updateOrder(order));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getOrder(@RequestParam int orderId){
        try {
            return  buildResponse(orderServices.getOrder(orderId));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOrder(@RequestParam int orderId){
        try {
            return  buildResponse(orderServices.deleteOrder(orderId));
        }catch (DataException e){
            return buildError(e);
        }
    }
}
