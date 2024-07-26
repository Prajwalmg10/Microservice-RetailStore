package com.online.retailStore.Services;

import com.online.retailStore.Pojos.Product;
import com.online.retailStore.UiResponse.DataException;

public interface ShoppingServices {

    Product createProduct(Product product) throws DataException;
}
