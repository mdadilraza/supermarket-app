package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.model.Stocks;
import com.eidiko.supermarket_action_service.services.StocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks/api")
public class StocksController {

    private final StocksService stocksService;


    public StocksController(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    @PostMapping("/addStocks")
    public ResponseEntity<String> addStocks(@RequestBody Stocks stocks)
    {
        return ResponseEntity.ok(stocksService.addStocks(stocks));
    }
}
