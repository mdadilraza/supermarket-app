package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.dto.SaleRequest;
import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
import com.eidiko.supermarket_action_service.model.Sale;
import com.eidiko.supermarket_action_service.response.ApiResponseEntity;
import com.eidiko.supermarket_action_service.services.SalesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sales/api")
@Tag(name = "Sales_Api")
public class SalesController {

    private final SalesService salesService;
    @Autowired
    public SalesController(SalesService salesService)
    {
        this.salesService=salesService;
    }

    @PostMapping("/addSales")
    public ResponseEntity<ApiResponseEntity<Sale>> addSales(@RequestBody SaleRequest saleRequest) throws InsufficientStockException, EmployeeNotFoundException {
        ApiResponseEntity<Sale> apiResponseEntity =new ApiResponseEntity<>(
                HttpStatus.CREATED,
                "Sales added",
                salesService.addSales(saleRequest)
        );
        return new ResponseEntity<>(apiResponseEntity,HttpStatus.OK);
    }

}
