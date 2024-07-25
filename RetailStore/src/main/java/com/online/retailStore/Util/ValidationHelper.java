package com.online.retailStore.Util;

import com.online.retailStore.Pojos.Product;
import com.online.retailStore.UiResponse.DataException;
import org.springframework.http.HttpStatus;

public class ValidationHelper {

    public static void validateProduct(Product product) throws DataException {
        if(NullEmptyUtils.isEmpty(product.getProductName())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_NAME_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isEmpty(product.getProductDescription())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_DESCRIPTION_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isNullorEmpty(product.getPrice())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_PRICE_REQUIRED, HttpStatus.BAD_REQUEST);
        }
    }

}
