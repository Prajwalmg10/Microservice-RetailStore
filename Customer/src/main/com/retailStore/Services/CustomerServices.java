package Customer.src.main.com.retailStore.Services;

import Customer.src.main.com.retailStore.Models.Customer;
import Customer.src.main.com.retailStore.uiResponse.DataException;

public interface CustomerServices {
    Customer saveCustomer(Customer customerModel) throws DataException;

    Customer updateCustomer(Customer customer) throws DataException;

    String deleteCustomer(int customerId) throws DataException;

    Customer getCustomer(int customerId) throws DataException;
}
