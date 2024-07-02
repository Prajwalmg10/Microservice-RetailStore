package com.example.retailStore.Services.Implementation;

import com.example.retailStore.Models.CustomerAddress;
import com.example.retailStore.Repository.AddressRepository;
import com.example.retailStore.Services.AddressServices;
import com.example.retailStore.Util.NullEmptyUtils;
import com.example.retailStore.Util.StringConstants;
import com.example.retailStore.uiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.retailStore.Util.ValidationHelper.validateAddress;

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
