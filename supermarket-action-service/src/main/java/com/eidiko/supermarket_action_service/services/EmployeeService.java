package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.dao.EmployeeRepo;
import com.eidiko.supermarket_action_service.model.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepos)
    {
        this.employeeRepo=employeeRepos;
    }

    public String addEmployees(Employee employee)
    {
        return employeeRepo.addEmployee(employee);
    }

    public int updateUserDetails(int userId, String newPhoneNumber, String newEmail, String newPassword) {
//        StringBuilder sql = new StringBuilder("UPDATE employees SET ");
//        boolean hasField = false;
//
//        if (newPhoneNumber != null) {
//            sql.append("phone_number = ?, ");
//            hasField = true;
//        }
//        if (newEmail != null) {
//            sql.append("email = ?, ");
//            hasField = true;
//        }
//        if (newPassword != null) {
//            sql.append("password = ?, ");
//            hasField = true;
//        }
//
//
//        if (hasField) {
//            sql.setLength(sql.length() - 2);
//            sql.append(" WHERE id = ?");
//        } else {
//            return 0;
//        }
//        System.out.println(newPhoneNumber);
//        System.out.println(sql);
//
//        // Construct the parameters list dynamically based on which fields are provided
//        List<Object> params = new ArrayList<>();
//        if (newPhoneNumber != null) params.add(newPhoneNumber);
//        if (newEmail != null) params.add(newEmail);
//        if (newPassword != null) params.add(newPassword);
//        params.add(userId);
//        return jdbcTemplate.update(sql.toString(), params.toArray());
    return 0;
    }

    public String deleteEmployee(int id)
    {
        return employeeRepo.deleteEmployee(id);
    }
    
}
