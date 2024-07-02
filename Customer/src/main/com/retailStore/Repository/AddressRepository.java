package Customer.src.main.com.retailStore.Repository;

import Customer.src.main.com.retailStore.Models.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<CustomerAddress,Integer> {
}
