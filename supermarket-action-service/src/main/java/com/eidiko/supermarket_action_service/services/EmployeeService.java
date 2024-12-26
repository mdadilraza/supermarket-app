package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeService(@Qualifier("postgresqlJdbcTemplate") JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }

    public String addEmployees(Employee employee)
    {
        String query="INSERT INTO employees (name,email,password,designation,role,phone_number,joining_date,salary,reporting_to) VALUES (?, ?, ?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,employee.getName(),employee.getEmail(),employee.getPassword(),employee.getDesignation(),employee.getRole(),employee.getPhoneNumber(),employee.getJoiningDate(),employee.getSalary(),employee.getReportingTo());
        return "employee added";
    }
    
}
