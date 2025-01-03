package com.eidiko.supermarket_integration_service.actionClient;

import com.eidiko.supermarket_integration_service.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="action-employee",url = "http://10.0.0.7:8081/employees/api")
public interface EmployeeActionClient {
    @PostMapping("/addEmployee")
     ResponseEntity<String> addEmployees(@RequestBody Employee employee);

    @PatchMapping("/updateEmployee/{id}")
     String updateUser(@PathVariable int id ,@RequestBody Employee employee) ;

    @DeleteMapping("/deleteEmployee/{id}")
     String deleteEmployee(@PathVariable int id);
}
