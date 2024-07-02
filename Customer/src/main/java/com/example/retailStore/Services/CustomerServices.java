package com.example.retailStore.Services;

import com.example.retailStore.Models.Customer;
import com.example.retailStore.uiResponse.DataException;

public interface CustomerServices {
    Customer saveCustomer(Customer customerModel) throws DataException;

    Customer updateCustomer(Customer customer) throws DataException;

    String deleteCustomer(int customerId) throws DataException;

    Customer getCustomer(int customerId) throws DataException;
}
