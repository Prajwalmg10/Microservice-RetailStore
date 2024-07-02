package com.example.retailStore.Services.Implementation;

import com.example.retailStore.Models.Customer;
import com.example.retailStore.Models.CustomerAddress;
import com.example.retailStore.Repository.CustomerRepository;
import com.example.retailStore.Services.AddressServices;
import com.example.retailStore.Services.CustomerServices;
import com.example.retailStore.Util.NullEmptyUtils;
import com.example.retailStore.Util.StringConstants;
import com.example.retailStore.Util.ValidationHelper;
import com.example.retailStore.uiResponse.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
