package com.eidiko.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private int id;
    private double saleAmount;
    private List<Integer> stocks;
    private LocalDateTime date;
    private EmployeeDTO employeeId;

}
