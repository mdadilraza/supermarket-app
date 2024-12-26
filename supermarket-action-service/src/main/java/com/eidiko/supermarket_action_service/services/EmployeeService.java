package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.dao.EmployeeRepo;
import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.model.Employee;
import org.springframework.stereotype.Service;
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
    return employeeRepo.updateUserDetails(userId,newPhoneNumber,newEmail,newPassword);
    }

    public String deleteEmployee(int id) throws EmployeeNotFoundException {
        return employeeRepo.deleteEmployee(id);
    }
    
}
