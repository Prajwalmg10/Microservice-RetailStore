package Product.src.main.com.retailStore.Services;

import Customer.src.main.com.retailStore.Models.Product;
import Customer.src.main.com.retailStore.uiResponse.DataException;

public interface ProductServices {
    Product addProduct(Product product) throws DataException;

    String deleteProduct(int productId) throws DataException;

    Product update(Product product) throws DataException;

    Product searchProduct(int productId) throws DataException;
}
