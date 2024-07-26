package com.online.retailStore.Services.Implementation;

import com.online.retailStore.Pojos.Product;
import com.online.retailStore.UiResponse.DataException;
import com.online.retailStore.Util.StringConstants;
import com.online.retailStore.Util.WSClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServicesImpl implements com.online.retailStore.Services.ShoppingServices {
    @Autowired
    private WSClientTemplate wsClientTemplate;
    @Override
    public Product createProduct(Product product) throws DataException {
        try{
            wsClientTemplate.invokeRESTService("",product, MediaType.APPLICATION_JSON, HttpMethod.POST);

        }
        catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION, e.getMessage(), HttpStatus.CONFLICT);
        }
        return null;
    }
}
