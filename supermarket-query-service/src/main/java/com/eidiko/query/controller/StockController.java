package com.eidiko.query.controller;

import com.eidiko.query.exception.StockNotFoundException;
import com.eidiko.query.model.Stock;
import com.eidiko.query.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable int id) throws StockNotFoundException {
        return stockService.getStockById(id);
    }

    @GetMapping
    public List<Stock> getAllEmployees() {
        return stockService.getAllStocks();
    }

}
