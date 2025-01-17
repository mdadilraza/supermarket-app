package com.eidiko.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    private int id;
    private String name;
    private String category;
    private int quantity;
    private double price;

}
