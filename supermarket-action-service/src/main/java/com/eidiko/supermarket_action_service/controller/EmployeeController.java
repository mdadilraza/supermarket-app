package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.model.Employee;
import com.eidiko.supermarket_action_service.response.ApiResponseEntity;
import com.eidiko.supermarket_action_service.services.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees/api")
@Tag(name = "Employee_Api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    //Add employee
    @PostMapping("/addEmployee")
    public ResponseEntity<ApiResponseEntity<Employee>> addEmployees(@RequestBody Employee employee)
    {
        ApiResponseEntity<Employee> response = new ApiResponseEntity<>(
                HttpStatus.CREATED,
                "Employee added successfully",
                employeeService.addEmployees(employee)
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Update employee
    @PatchMapping("/updateEmployee/{id}")
    public ResponseEntity<ApiResponseEntity<Employee>> updateUser(@PathVariable int id,
                                                                  @RequestBody Employee employee) {
       ApiResponseEntity<Employee> apiResponseEntity =new ApiResponseEntity<>(
               HttpStatus.OK,
               "employee details updated successfully",
               employeeService.updateUserDetails(id, employee.getPhoneNumber(),employee.getEmail(),employee.getPassword())
       );
       return new ResponseEntity<>(apiResponseEntity,HttpStatus.CREATED);
    }

    //delete employee based on id
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        return employeeService.deleteEmployee(id);
    }

}
