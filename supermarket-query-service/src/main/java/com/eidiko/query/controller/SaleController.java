package com.eidiko.query.controller;

import com.eidiko.query.dto.SaleDTO;
import com.eidiko.query.exception.SaleNotFoundException;
import com.eidiko.query.service.SaleService;
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
    public SaleDTO getEmployeeById(@PathVariable int id) throws SaleNotFoundException {
        return saleService.getSaleById(id);
    }

    @GetMapping
    public List<SaleDTO> getAllEmployees() {
        return saleService.getAllSales();
    }

}
