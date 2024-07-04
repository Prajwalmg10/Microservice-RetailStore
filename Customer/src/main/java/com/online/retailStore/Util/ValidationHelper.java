package com.online.retailStore.Util;

import com.online.retailStore.Models.Customer;
import com.online.retailStore.Models.CustomerAddress;
import com.online.retailStore.uiResponse.DataException;
import org.springframework.http.HttpStatus;

public class ValidationHelper {
    public static void validateCustomerBean(Customer customer) throws DataException {
        if(NullEmptyUtils.isEmpty(customer.getCustomerName())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.CUSTOMER_NAME_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isEmpty(customer.getCustomerEmail())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.CUSTOMER_EMAIL_REQUIRED, HttpStatus.BAD_REQUEST);
        }
                for(CustomerAddress address: customer.getShippingAddress()){
                    validateAddress(address,"Shipping");
                }
                for(CustomerAddress address: customer.getBillingAddress()) {
                    validateAddress(address, "Billing");
                }
    }

    public static void validateAddress(CustomerAddress address,String type) throws DataException{
        if(NullEmptyUtils.isEmpty(address.getDoorNo())){
            throw new DataException(StringConstants.EXCEPTION,type+StringConstants.DOORNO_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isEmpty(address.getCity())){
            throw new DataException(StringConstants.EXCEPTION,type+StringConstants.CITY_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isEmpty(address.getLayout())){
            throw new DataException(StringConstants.EXCEPTION,type+StringConstants.LAYOUT_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isEmpty(address.getPincode())){
            throw new DataException(StringConstants.EXCEPTION,type+StringConstants.PINCODE_REQUIRED, HttpStatus.BAD_REQUEST);
        }
        if(NullEmptyUtils.isEmpty(address.getStreetName())){
            throw new DataException(StringConstants.EXCEPTION,type+StringConstants.STREETNAME_REQUIRED, HttpStatus.BAD_REQUEST);
        }
    }

}
