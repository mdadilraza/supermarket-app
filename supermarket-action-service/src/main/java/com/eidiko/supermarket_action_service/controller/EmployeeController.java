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
                             @RequestParam(required = false) String newPhoneNumber,
                             @RequestParam(required = false) String newEmail,
                             @RequestParam(required = false) String newPassword) {
        int rowsUpdated = employeeService.updateUserDetails(id, newPhoneNumber, newEmail, newPassword);

        if (rowsUpdated > 0) {
            return "User details updated successfully!";
        } else {
            return "User not found or no updates made!";
        }
    }



    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        return employeeService.deleteEmployee(id);
    }

}
