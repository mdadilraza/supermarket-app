package com.eidiko.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncentiveDTO {

    private int id;
    private double incentiveAmount;
    private EmployeeDTO employeeId;
    private SaleDTO saleId;
    private LocalDate date = LocalDate.now();

}
