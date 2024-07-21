package com.online.retailStore.Pojos;

import lombok.Data;

@Data
public class Product {
    String productName;
    String productDescription;
    int price;
    int quantity;
}
