package com.eidiko.supermarket_action_service.dao;

import com.eidiko.supermarket_action_service.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    public int updateUserDetails(int id, String phoneNumber, String newEmail, String newPassword) {
        StringBuilder sql = new StringBuilder("UPDATE employees SET ");
        List<Object> params = new ArrayList<>();
        // Dynamically add the columns that are not null
        boolean isFirst = true;

        if (phoneNumber != null) {
            System.out.println(phoneNumber);
            sql.append("phone_number = ?");
            params.add(phoneNumber);
            isFirst = false;
        }

        if (newEmail != null) {
            if (!isFirst) sql.append(", ");
            sql.append("email = ?");
            params.add(newEmail);
            isFirst = false;
        }

        if (newPassword != null) {
            if (!isFirst) sql.append(", ");
            sql.append("password = ?");
            params.add(newPassword);
        }
        sql.append(" WHERE id = ?");
        params.add(id);
        return jdbcTemplate.update(sql.toString(), params.toArray());
    }


}