package com.online.retailStore.Controllers;

import com.online.retailStore.Models.Cart;
import com.online.retailStore.Services.CartServices;
import com.online.retailStore.UiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/cart")
public class CartController extends AbstarctController {

    @Autowired
    private CartServices cartServices;

    @PostMapping("/create")
    public ResponseEntity<?> createCart(@RequestBody Cart cart){
        try{
            return buildResponse(cartServices.createCart(cart));
        } catch (DataException e) {
            return buildError(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCart(@RequestBody Cart cart){
        try{
            return buildResponse(cartServices.updateCart(cart));
        } catch (DataException e) {
            return buildError(e);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCart(@RequestParam int cartId){
        try{
            return buildResponse(cartServices.getCart(cartId));
        } catch (DataException e) {
            return buildError(e);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCart(@RequestParam int cartId){
        try{
            return buildResponse(cartServices.deleteCart(cartId));
        } catch (DataException e) {
            return buildError(e);
        }
    }

}
