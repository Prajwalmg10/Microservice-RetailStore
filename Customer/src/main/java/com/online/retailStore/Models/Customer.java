package com.online.retailStore.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name ="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name ="customer_name")
    private String customerName;

    @Column(name="customer_email")
    private String customerEmail;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ba_customer_id",referencedColumnName = "customer_id")
    private List<CustomerAddress> billingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sa_customer_id",referencedColumnName = "customer_id")
    private List<CustomerAddress> shippingAddress;
}
