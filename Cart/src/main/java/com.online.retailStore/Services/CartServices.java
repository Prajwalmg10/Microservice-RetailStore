package com.online.retailStore.Services;

import com.online.retailStore.Models.Cart;
import com.online.retailStore.UiResponse.DataException;

public interface CartServices {

    Cart createCart(Cart cart) throws DataException;

    String deleteCart(int cartId) throws DataException;

    Cart updateCart(Cart orderId) throws DataException;

    Cart getCart(int cartId) throws DataException;
}
