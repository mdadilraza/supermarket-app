package com.eidiko.supermarket_integration_service.queryclient;

import com.eidiko.supermarket_integration_service.dto.SaleDTO;
import com.eidiko.supermarket_integration_service.helper.ApiResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="query-sales",url = "http://10.0.0.42:8082/api/sales")
public interface SalesQueryClient {

    @GetMapping("/{id}")
    ResponseEntity<ApiResponseEntity<SaleDTO>> getSaleById(@PathVariable int id);

    @GetMapping
    ResponseEntity<ApiResponseEntity<List<SaleDTO>>> getAllSales();

    @GetMapping("/employee/{employeeId}")
    ResponseEntity<ApiResponseEntity<List<SaleDTO>>> getSalesByEmployeeID(@PathVariable int employeeId);
}
