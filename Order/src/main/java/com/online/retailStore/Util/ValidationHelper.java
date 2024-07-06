package com.online.retailStore.Util;


import com.online.retailStore.Models.Order;
import com.online.retailStore.uiResponse.DataException;
import org.springframework.http.HttpStatus;

public class ValidationHelper {
    public static void validateProduct(Order product) throws DataException {
        if(NullEmptyUtils.isEmpty(product.get())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_NAME_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isEmpty(product.getDescription())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_DESCRIPTION_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isNullorEmpty(product.getProductPrice())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_PRICE_REQUIRED, HttpStatus.BAD_REQUEST);
        }
    }
}
