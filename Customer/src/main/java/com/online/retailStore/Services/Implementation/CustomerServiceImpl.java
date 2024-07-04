package com.online.retailStore.Services.Implementation;

import com.online.retailStore.Repository.CustomerRepository;
import com.online.retailStore.Models.Customer;
import com.online.retailStore.Services.AddressServices;
import com.online.retailStore.Services.CustomerServices;
import com.online.retailStore.Util.NullEmptyUtils;
import com.online.retailStore.Util.StringConstants;
import com.online.retailStore.Util.ValidationHelper;
import com.online.retailStore.uiResponse.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressServices addressServices;

    @Override
    public Customer saveCustomer(Customer customer) throws DataException {
        ValidationHelper.validateCustomerBean(customer);
        try{
               Optional<Customer> existCustomer= customerRepository.findByCustomerEmail(customer.getCustomerEmail());
               if(existCustomer.isPresent()){
                   throw new DataException("Exception","Customer Email Address Already Exists", HttpStatus.BAD_REQUEST);
               }
            log.info("Saving new customer");
            return customerRepository.save(customer);
        }catch (Exception e){
            log.error(e.getMessage());
           throw new DataException("Exception",e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) throws DataException {
        ValidationHelper.validateCustomerBean(customer);
        if(NullEmptyUtils.isNullorEmpty(customer.getCustomerId())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_CUSTOMERID,HttpStatus.BAD_REQUEST);
        }
        try{
            Optional<Customer> existCustomer= customerRepository.findByCustomerEmail(customer.getCustomerEmail());
            if(existCustomer.isPresent()&& !Objects.equals(customer.getCustomerId(), existCustomer.get().getCustomerId())){
                throw new DataException("Exception","Customer Email Address Already Exists", HttpStatus.BAD_REQUEST);
            }

            return customerRepository.save(customer);
        }catch (Exception e){
            throw new DataException("Exception",e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public String deleteCustomer(int customerId) throws DataException {
        Customer customer=getCustomer(customerId);
        if(NullEmptyUtils.isNull(customer)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_CUSTOMERID,HttpStatus.BAD_REQUEST);
        }
        customerRepository.delete(customer);
        return "Deleted Successfully";
    }

    @Override
    public Customer getCustomer(int customerId) throws DataException {
       Optional<Customer> customer= customerRepository.findById(customerId);
        return customer.orElse(null);
    }
}
