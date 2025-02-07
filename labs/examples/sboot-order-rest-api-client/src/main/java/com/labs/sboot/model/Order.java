package com.labs.sboot.model;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String description;
    private String category;
    private int quantity;
    private double price;
}
