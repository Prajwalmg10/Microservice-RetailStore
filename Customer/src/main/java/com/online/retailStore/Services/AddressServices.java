package com.online.retailStore.Services;

import com.online.retailStore.Models.CustomerAddress;
import com.online.retailStore.UiResponse.DataException;

public interface AddressServices {
    CustomerAddress saveAddress(CustomerAddress address, String type) throws DataException;

    CustomerAddress getAddress(int addressId) throws DataException;

    void deleteAddress(int addressId) throws DataException;
}
