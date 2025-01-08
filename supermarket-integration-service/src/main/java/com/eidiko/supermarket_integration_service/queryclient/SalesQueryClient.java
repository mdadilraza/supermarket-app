package com.eidiko.supermarket_integration_service.queryclient;

import com.eidiko.supermarket_integration_service.dto.SaleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="query-sales",url = "http://10.0.0.42:8082/api/sales")
public interface SalesQueryClient {

    @GetMapping("/{id}")
    public SaleDto getEmployeeById(@PathVariable int id);

    @GetMapping
    public List<SaleDto> getAllEmployees();
}
