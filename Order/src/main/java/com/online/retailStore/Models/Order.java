package com.online.retailStore.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_item_id",referencedColumnName = "order_id")
    private List<LineItem> lineItems;
}
