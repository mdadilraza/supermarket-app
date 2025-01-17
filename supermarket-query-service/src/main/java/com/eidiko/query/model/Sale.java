package com.eidiko.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    private int id;
    private double saleAmount;
    private List<Integer> stocks;
    private LocalDateTime date = LocalDateTime.now();
    private Employee employeeId;

}
