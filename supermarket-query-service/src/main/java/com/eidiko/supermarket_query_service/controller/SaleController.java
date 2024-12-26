package com.eidiko.supermarket_query_service.controller;

import com.eidiko.supermarket_query_service.exception.SaleNotFoundException;
import com.eidiko.supermarket_query_service.model.Sale;
import com.eidiko.supermarket_query_service.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/{id}")
    public Sale getEmployeeById(@PathVariable int id) throws SaleNotFoundException {
        return saleService.getSaleById(id);
    }

    @GetMapping
    public List<Sale> getAllEmployees() {
        return saleService.getAllSales();
    }

}
