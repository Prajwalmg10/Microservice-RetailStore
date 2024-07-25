package com.online.retailStore.Controllers;

import com.online.retailStore.Pojos.Product;
import com.online.retailStore.Services.ShoppingServices;
import com.online.retailStore.UiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/shippingService")
public class ProductController extends AbstarctController {

    @Autowired
    private ShoppingServices shoppingServices;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        try{
         return    buildResponse(shoppingServices.createProduct(product));
        }catch (DataException e){
         return    buildError(e);
        }
    }

}
