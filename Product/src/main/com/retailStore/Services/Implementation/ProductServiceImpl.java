package Product.src.main.com.retailStore.Services.Implementation;

import Customer.src.main.com.retailStore.Models.Product;
import Product.src.main.com.retailStore.Repository.ProductRepository;
import Product.src.main.com.retailStore.Services.ProductServices;
import Customer.src.main.com.example.retailStore.Util.NullEmptyUtils;
import Customer.src.main.com.example.retailStore.Util.StringConstants;
import Customer.src.main.com.example.retailStore.Util.ValidationHelper;
import Customer.src.main.com.retailStore.uiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) throws DataException {
        ValidationHelper.validateProduct(product);
        try{
            return productRepository.save(product);
        }catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String deleteProduct(int productId) throws DataException {
        Product product=searchProduct(productId);
        if(NullEmptyUtils.isNull(product)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID,HttpStatus.BAD_REQUEST);
        }
        return StringConstants.SUCCESS;
    }

    @Override
    public Product update(Product product) throws DataException {
        ValidationHelper.validateProduct(product);
        if(NullEmptyUtils.isNullorEmpty(product.getProductId())){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID,HttpStatus.BAD_REQUEST);
        }
        try{
            return productRepository.save(product);
        }catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Product searchProduct(int productId) throws DataException {
        if(NullEmptyUtils.isNullorEmpty(productId)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID,HttpStatus.BAD_REQUEST);
        }
       return productRepository.findById(productId).get();
    }
}
