package com.online.retailStore.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Data
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_productId")
    private int productId;

    @Column(name = "item_productName")
    private String productName;

    @Column(name="item_quantity")
    private int quantity;

    @Column(name = "item_price")
    private int price;
}
