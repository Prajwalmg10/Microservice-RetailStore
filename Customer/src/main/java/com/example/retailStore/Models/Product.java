package com.example.retailStore.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Column(name = "p_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "p_name")
    private String productName;

    @Column(name = "p_description")
    private String description;

    @Column(name="p_price")
    private int productPrice;

}
