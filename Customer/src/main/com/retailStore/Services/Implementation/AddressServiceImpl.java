package Customer.src.main.com.retailStore.Services.Implementation;

import Customer.src.main.com.retailStore.Models.CustomerAddress;
import Customer.src.main.com.retailStore.Repository.AddressRepository;
import Customer.src.main.com.retailStore.Services.AddressServices;
import Customer.src.main.com.example.retailStore.Util.NullEmptyUtils;
import Customer.src.main.com.example.retailStore.Util.StringConstants;
import Customer.src.main.com.retailStore.uiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static Customer.src.main.com.example.retailStore.Util.ValidationHelper.validateAddress;

@Service
@Transactional
public class AddressServiceImpl implements AddressServices {

    @Autowired
    public AddressRepository addressRepository;

    @Override
    public CustomerAddress saveAddress(CustomerAddress address, String type) throws DataException {
        validateAddress(address,type);
        return  addressRepository.save(address);
    }

    @Override
    public CustomerAddress getAddress(int addressId) throws DataException {
        Optional<CustomerAddress> address=addressRepository.findById(addressId);
        return address.orElse(null);
    }

    @Override
    public void deleteAddress(int addressId) throws DataException {
       CustomerAddress address= getAddress(addressId);
       if(NullEmptyUtils.isNull(address)){
           throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_ADDRESSID, HttpStatus.BAD_REQUEST);
       }
        addressRepository.delete(address);
    }


}
