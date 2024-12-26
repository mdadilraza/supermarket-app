package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.model.Employee;
import com.eidiko.supermarket_action_service.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
