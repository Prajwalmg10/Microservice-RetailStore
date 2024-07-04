package com.online.retailStore.Util;

import com.online.retailStore.Models.Inventory;
import com.online.retailStore.uiResponse.DataException;
import org.springframework.http.HttpStatus;

public class ValidationHelper {

    public static void validateInventory(Inventory inventory) throws DataException {
        if(NullEmptyUtils.isNullorEmpty(inventory.getProductId())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isNullorEmpty(inventory.getQuantity())||inventory.getQuantity()<0){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.PRODUCT_QUANTITY_REQUIRED, HttpStatus.BAD_REQUEST);
        }
    }
}
