package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.model.Employee;
import com.eidiko.supermarket_action_service.services.EmployeeService;
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
    public ResponseEntity<String> addEmployees(@RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeService.addEmployees(employee));
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
    public String deleteEmployee(@PathVariable int id)
    {
        return employeeService.deleteEmployee(id);
    }

}
