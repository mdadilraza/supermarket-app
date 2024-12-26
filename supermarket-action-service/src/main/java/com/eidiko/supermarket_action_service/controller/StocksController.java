package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.model.Stocks;
import com.eidiko.supermarket_action_service.services.StocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/updateStocks/{id}")
    public ResponseEntity<String> updateStocks(@PathVariable int id,@RequestBody Stocks stocks)
    {
        stocksService.updateStocks(id,stocks);
        return ResponseEntity.ok("stocks updated successfully");
    }

    @DeleteMapping("/deleteStock/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable int id)
    {
        return ResponseEntity.ok(stocksService.deleteStock(id));
    }

}
