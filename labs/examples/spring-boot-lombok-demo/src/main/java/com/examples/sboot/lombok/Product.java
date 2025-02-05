package com.examples.sboot.lombok;

import lombok.*;

@Setter
@Getter
@ToString
//@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String category;
    private String name;
    private String manufacturer;
    private double price;
}
