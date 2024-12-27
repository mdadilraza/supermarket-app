package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.model.Employee;
import com.eidiko.supermarket_action_service.response.ApiResponse;
import com.eidiko.supermarket_action_service.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<ApiResponse<Employee>> addEmployees(@RequestBody Employee employee)
    {
        ApiResponse<Employee> response = new ApiResponse<>(
                HttpStatus.CREATED,
                "Employee added successfully",
                employeeService.addEmployees(employee)
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/updateEmployee/{id}")
    public String updateUser(@PathVariable int id,
                             @RequestBody Employee employee) {
        System.out.println(employee.getPhoneNumber());
        int rowsUpdated = employeeService.updateUserDetails(id, employee.getPhoneNumber(),employee.getEmail(),employee.getPassword());

        if (rowsUpdated > 0) {
            return "Employee details updated successfully!";
        } else {
            return "No employee found with the given ID!";
        }
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        return employeeService.deleteEmployee(id);
    }

}
