package com.eidiko.query.service;

import com.eidiko.query.dto.SaleDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.exception.SaleNotFoundException;

import java.util.List;

public interface SaleService {

    SaleDTO getSaleById(int id) throws SaleNotFoundException;

    List<SaleDTO> getSalesByEmployeeId(int employeeId) throws EmployeeNotFoundException;

    List<SaleDTO> getAllSales();

}
