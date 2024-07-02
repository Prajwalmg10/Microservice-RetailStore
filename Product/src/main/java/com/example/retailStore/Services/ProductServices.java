package com.example.retailStore.Services;

import com.example.retailStore.Models.Product;
import com.example.retailStore.uiResponse.DataException;

public interface ProductServices {
    Product addProduct(Product product) throws DataException;

    String deleteProduct(int productId) throws DataException;

    Product update(Product product) throws DataException;

    Product searchProduct(int productId) throws DataException;
}
