package com.eidiko.supermarket_integration_service.queryclient;

import com.eidiko.supermarket_integration_service.dto.EmployeeDTO;
import com.eidiko.supermarket_integration_service.dto.EmployeeHierarchyDTO;
import com.eidiko.supermarket_integration_service.helper.ApiResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="query-employee",url = "http://10.0.0.42:8082/api/employees")
public interface EmployeeQueryClient {

    @GetMapping("/{id}")
     ResponseEntity<ApiResponseEntity<EmployeeDTO>> getEmployeeById(@PathVariable int id);

    @GetMapping
    ResponseEntity<ApiResponseEntity<List<EmployeeDTO>>> getAllEmployees();

    @GetMapping("/hierarchy")
     ResponseEntity<ApiResponseEntity<EmployeeHierarchyDTO>> getHierarchy();

    @GetMapping("/hierarchy/{id}")
     ResponseEntity<ApiResponseEntity<List<Integer>>> getHierarchyById(@PathVariable int id);
}
