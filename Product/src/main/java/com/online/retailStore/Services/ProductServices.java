package com.online.retailStore.Services;

import com.online.retailStore.Models.Product;
import com.online.retailStore.UiResponse.DataException;

public interface ProductServices {
    Product addProduct(Product product) throws DataException;

    String deleteProduct(int productId) throws DataException;

    Product update(Product product) throws DataException;

    Product searchProduct(int productId) throws DataException;
}
