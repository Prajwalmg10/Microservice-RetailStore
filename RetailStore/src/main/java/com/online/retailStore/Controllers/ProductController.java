package com.online.retailStore.Controllers;

import com.online.retailStore.Models.Product;
import com.online.retailStore.Services.ProductServices;
import com.online.retailStore.uiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/rest/product")
public class ProductController extends AbstarctController{

    @Autowired
    private ProductServices productServices;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        try{
            return buildResponse(productServices.addProduct(product));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        try{
            return buildResponse(productServices.update(product));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getProduct(@RequestParam int productId){
        try{
            return buildResponse(productServices.searchProduct(productId));
        }catch (DataException e){
            return buildError(e);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam int productId){
        try{
            return buildResponse(productServices.deleteProduct(productId));
        }catch (DataException e){
            return buildError(e);
        }
    }
}
