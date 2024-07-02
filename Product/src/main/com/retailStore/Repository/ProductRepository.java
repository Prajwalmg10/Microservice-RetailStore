package Product.src.main.com.retailStore.Repository;

import Customer.src.main.com.retailStore.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
