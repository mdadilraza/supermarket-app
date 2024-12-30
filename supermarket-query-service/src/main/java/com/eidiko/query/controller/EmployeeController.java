package com.eidiko.query.controller;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.response.ApiResponse;
import com.eidiko.query.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeDTO>> getEmployeeById(@PathVariable int id)
            throws EmployeeNotFoundException {
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK,
                "Employee Fetched",
                employeeService.getEmployeeById(id)
        ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeDTO>>> getAllEmployees() {
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK,
                "Employees Fetched",
                employeeService.getAllEmployees()
        ));
    }

}
