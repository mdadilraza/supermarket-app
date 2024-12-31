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

    //Add employee
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

    //Update employee
    @PatchMapping("/updateEmployee/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateUser(@PathVariable int id,
                             @RequestBody Employee employee) {
       ApiResponse<Employee>apiResponse=new ApiResponse<>(
               HttpStatus.OK,
               "employee details updated successfully",
               employeeService.updateUserDetails(id, employee.getPhoneNumber(),employee.getEmail(),employee.getPassword())
       );
       return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

    //delete employee based on id
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        return employeeService.deleteEmployee(id);
    }

}
