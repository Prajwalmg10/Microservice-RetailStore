package Inventory.src.main.com.retailStore.Services.Implementation;

import Customer.src.main.com.retailStore.Models.Inventory;
import Customer.src.main.com.retailStore.Models.Product;
import Inventory.src.main.com.retailStore.Services.InventoryServices;
import Inventory.src.main.com.retailStore.Repository.InventoryRepository;
import Product.src.main.com.retailStore.Repository.ProductRepository;
import Customer.src.main.com.example.retailStore.Util.NullEmptyUtils;
import Customer.src.main.com.example.retailStore.Util.StringConstants;
import Customer.src.main.com.example.retailStore.Util.ValidationHelper;
import Customer.src.main.com.retailStore.uiResponse.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryServices {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Inventory addToInventory(Inventory inventory) throws DataException {
        try{
            ValidationHelper.validateInventory(inventory);
            Optional<Product> product=productRepository.findById(inventory.getProductId());
            if(product.isEmpty()){
                throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID,HttpStatus.BAD_REQUEST);
            }
            return inventoryRepository.save(inventory);
        }catch (DataException e){
            throw e;
        }catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public Inventory searchInventory(int inventoryId) throws DataException {
        if(NullEmptyUtils.isNullorEmpty(inventoryId)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_INVENTORY_ID,HttpStatus.BAD_REQUEST);
        }
        return inventoryRepository.getById(inventoryId);
    }

    @Override
    public String deleteInventory(int inventoryId) throws DataException {
        Inventory inventory=searchInventory(inventoryId);
        if(NullEmptyUtils.isNull(inventory)){
            throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_INVENTORY_ID,HttpStatus.BAD_REQUEST);
        }
        inventoryRepository.delete(inventory);
        return StringConstants.SUCCESS;
    }

    @Override
    public Inventory updateInventory(Inventory inventory) throws DataException {
        try{
            ValidationHelper.validateInventory(inventory);
            if(NullEmptyUtils.isNullorEmpty(inventory.getInventoryId())){
                throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_INVENTORY_ID,HttpStatus.BAD_REQUEST);
            }
            Optional<Inventory> inventoryBean=inventoryRepository.findById(inventory.getInventoryId());
            if(inventoryBean.isEmpty()){
                throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_INVENTORY_ID,HttpStatus.BAD_REQUEST);
            }
            Optional<Product> product=productRepository.findById(inventory.getProductId());
            if(product.isEmpty()){
                throw new DataException(StringConstants.EXCEPTION,StringConstants.INVALID_PRODUCT_ID,HttpStatus.BAD_REQUEST);
            }
            return inventoryRepository.save(inventory);
        }catch (DataException e){
            throw e;
        }catch (Exception e){
            throw new DataException(StringConstants.EXCEPTION,e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
