package com.eidiko.supermarket_query_service.service;

import com.eidiko.supermarket_query_service.dto.EmployeeDTO;
import com.eidiko.supermarket_query_service.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO getEmployeeById(int id) throws EmployeeNotFoundException;
    List<EmployeeDTO> getAllEmployees();

}
