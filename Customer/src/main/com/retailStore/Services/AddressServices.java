package Customer.src.main.com.retailStore.Services;

import Customer.src.main.com.retailStore.Models.CustomerAddress;
import Customer.src.main.com.retailStore.uiResponse.DataException;

public interface AddressServices {
    CustomerAddress saveAddress(CustomerAddress address, String type) throws DataException;

    CustomerAddress getAddress(int addressId) throws DataException;

    void deleteAddress(int addressId) throws DataException;
}
