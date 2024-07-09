package com.online.retailStore.Util;


import com.online.retailStore.Models.LineItem;
import com.online.retailStore.Models.Order;
import com.online.retailStore.uiResponse.DataException;
import org.springframework.http.HttpStatus;

public class ValidationHelper {

    public static void validateOrder(Order order) throws DataException {
        if(NullEmptyUtils.isNull(order.getLineItems())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.EMPTY_ITEM,HttpStatus.BAD_REQUEST);
        }
        for (LineItem lineitem : order.getLineItems()){
            validateItem(lineitem);
        }
    }

    public static void validateItem(LineItem lineItem) throws DataException{
        if(NullEmptyUtils.isNullorEmpty(lineItem.getProductId())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isNullorEmpty(lineItem.getProductName())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_NAME_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isNullorEmpty(lineItem.getPrice())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_PRICE_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isNullorEmpty(lineItem.getQuantity())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_QUANTITY_REQUIRED, HttpStatus.BAD_REQUEST);
        }
    }
}
