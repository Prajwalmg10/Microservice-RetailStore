package com.online.retailStore.Services;

import com.online.retailStore.Models.Customer;
import com.online.retailStore.UiResponse.DataException;

public interface CustomerServices {
    Customer saveCustomer(Customer customerModel) throws DataException;

    Customer updateCustomer(Customer customer) throws DataException;

    String deleteCustomer(int customerId) throws DataException;

    Customer getCustomer(int customerId) throws DataException;
}
