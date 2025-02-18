package com.labs.orderapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @NotBlank(message = "Category cannot be blank")
    private String category;
    @Range(min = 1, max=100, message = "Quantity must be between 1 to 100")
    private int quantity;
    @Positive(message = "Price must be positive")
    private double price;

    public Order(String lenovoThinkPad, String laptops, int i, double v) {
    }
}
