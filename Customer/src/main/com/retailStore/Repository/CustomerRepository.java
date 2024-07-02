package Customer.src.main.com.retailStore.Repository;

import Customer.src.main.com.retailStore.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByCustomerEmail(String email);
}
