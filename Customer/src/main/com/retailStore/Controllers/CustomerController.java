package Customer.src.main.com.retailStore.Controllers;
import Customer.src.main.com.retailStore.Models.Customer;
import Customer.src.main.com.retailStore.Services.CustomerServices;
import Customer.src.main.com.retailStore.uiResponse.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/customer")
public class CustomerController extends AbstarctController {

    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        try {
             return  buildResponse(customerServices.saveCustomer(customer));
        }catch (DataException e){
             return  buildError(e);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        try {
            return  buildResponse(customerServices.updateCustomer(customer));
        }catch (DataException e){
            return  buildError(e);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCustomer(@RequestParam(name = "customerId") int customer){
        try {
            return  buildResponse(customerServices.getCustomer(customer));
        }catch (DataException e){
            return  buildError(e);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCustomer(@RequestParam(name = "customerId") int customerId){
        try {
            return  buildResponse(customerServices.deleteCustomer(customerId));
        }catch (DataException e){
            return  buildError(e);
        }
    }
}
