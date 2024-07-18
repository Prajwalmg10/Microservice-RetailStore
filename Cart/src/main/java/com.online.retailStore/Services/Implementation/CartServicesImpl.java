package com.online.retailStore.Services.Implementation;

import com.online.retailStore.Models.Cart;
import com.online.retailStore.Repository.CartRepository;
import com.online.retailStore.Services.CartServices;
import com.online.retailStore.Util.NullEmptyUtils;
import com.online.retailStore.Util.StringConstants;
import com.online.retailStore.Util.ValidationHelper;
import com.online.retailStore.UiResponse.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartServicesImpl implements CartServices {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart createCart(Cart cart) throws DataException {
        ValidationHelper.validateCart(cart);
        try{
            return cartRepository.save(cart);
        }catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String deleteCart(int cartId) throws DataException {
        Cart cart=getCart(cartId);
        if(NullEmptyUtils.isNull(cart)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_CART_ID,HttpStatus.BAD_REQUEST);
        }
        return StringConstants.SUCCESS;
    }

    @Override
    public Cart updateCart(Cart cart) throws DataException {
        ValidationHelper.validateCart(cart);
        if(NullEmptyUtils.isNullorEmpty(cart.getCartId())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_CART_ID,HttpStatus.BAD_REQUEST);
        }
        try{
            return cartRepository.save(cart);
        }catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Cart getCart(int cartId) throws DataException {
        if(NullEmptyUtils.isNullorEmpty(cartId)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_CART_ID,HttpStatus.BAD_REQUEST);
        }
        return cartRepository.findById(cartId).orElse(null);

    }
}
