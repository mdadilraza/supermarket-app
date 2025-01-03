package com.eidiko.supermarket_integration_service.controller;

import com.eidiko.supermarket_integration_service.dto.SaleRequest;
import com.eidiko.supermarket_integration_service.model.Sale;
import com.eidiko.supermarket_integration_service.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/integration/sales")
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/addSales")
    public ResponseEntity<Sale> addSales(@RequestBody SaleRequest sales) {
        return ResponseEntity.ok(saleService.buySales(sales));
    }

}
