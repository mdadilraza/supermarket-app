package com.eidiko.query.service;

import com.eidiko.query.dao.EmployeeDAO;
import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) throws EmployeeNotFoundException {
        return employeeDAO.findById(id);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeDAO.findAll();
    }

}
