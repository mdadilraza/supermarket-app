package com.eidiko.query.dao;

import com.eidiko.query.dto.SaleDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.exception.SaleNotFoundException;

import java.util.List;

public interface SaleDAO {

    SaleDTO findById(int id) throws SaleNotFoundException;

    List<SaleDTO> findAll();

    List<SaleDTO> findByEmployeeId(int id) throws EmployeeNotFoundException;

}
