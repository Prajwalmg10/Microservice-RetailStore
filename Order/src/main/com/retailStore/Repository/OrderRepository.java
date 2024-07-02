package Order.src.main.com.retailStore.Repository;

import Customer.src.main.com.retailStore.Models.Order;
import Customer.src.main.com.retailStore.uiResponse.DataException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order addOrder(Order order) throws DataException;

    String deleteOrder(int orderId) throws DataException;

    Order updateOrder(Order orderId) throws DataException;

    Order getOrder(int orderId) throws DataException;
}
