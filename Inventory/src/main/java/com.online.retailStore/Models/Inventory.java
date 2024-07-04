package com.online.retailStore.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
@Data
public class Inventory {

    @Id
    @Column(name = "i_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    @Column(name = "i_productId")
    private int productId;

    @Column(name = "i_quantity")
    private int quantity;


}
