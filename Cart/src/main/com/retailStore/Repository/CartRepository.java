package Cart.src.main.com.retailStore.Repository;

import Customer.src.main.com.retailStore.Models.Cart;
import Customer.src.main.com.retailStore.uiResponse.DataException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    Cart createCart(Cart cart) throws DataException;

    String deleteCart(int cartId) throws DataException;

    Cart UpdateCart(Cart cartId) throws DataException;

    Cart getCart(int cartId) throws DataException;
}
