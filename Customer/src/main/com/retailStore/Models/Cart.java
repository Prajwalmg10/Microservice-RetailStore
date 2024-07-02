package Customer.src.main.com.retailStore.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_item_id",referencedColumnName = "cart_id")
    private List<LineItem> lineItems;
}
