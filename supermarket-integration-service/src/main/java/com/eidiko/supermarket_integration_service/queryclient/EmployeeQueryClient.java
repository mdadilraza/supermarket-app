package com.eidiko.supermarket_integration_service.queryclient;
import com.eidiko.supermarket_integration_service.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name ="query-employee",url = "http://10.0.0.42:8082/api/employees")
public interface EmployeeQueryClient {
    @GetMapping("/{id}")
    EmployeeDTO getEmployeeById(@PathVariable int id);

    @GetMapping
    public List<EmployeeDTO> getAllEmployees();
}
