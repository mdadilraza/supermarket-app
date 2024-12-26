package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepo(@Qualifier("postgresqlJdbcTemplate")  JdbcTemplate jdbcTemplate1)
    {
        this.jdbcTemplate=jdbcTemplate1;
    }


    public String addEmployee(Employee employee)
    {
        String query="INSERT INTO employees (name,email,password,designation,role,phone_number,joining_date,salary,reporting_to) VALUES (?, ?, ?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,employee.getName(),employee.getEmail(),employee.getPassword(),employee.getDesignation(),employee.getRole(),employee.getPhoneNumber(),employee.getJoiningDate(),employee.getSalary(),employee.getReportingTo());
        return "employee added";
    }

    public String deleteEmployee(int id)
    {
        String sql="delete from employees where id=?";
        jdbcTemplate.update(sql,id);
        return "employee deleted";
    }


}
