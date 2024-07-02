package com.example.retailStore.Services;

import com.example.retailStore.Models.CustomerAddress;
import com.example.retailStore.uiResponse.DataException;

public interface AddressServices {
    CustomerAddress saveAddress(CustomerAddress address, String type) throws DataException;

    CustomerAddress getAddress(int addressId) throws DataException;

    void deleteAddress(int addressId) throws DataException;
}
