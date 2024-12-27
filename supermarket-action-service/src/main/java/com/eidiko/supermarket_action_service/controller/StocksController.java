package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Employee;
import com.eidiko.supermarket_action_service.model.Stocks;
import com.eidiko.supermarket_action_service.response.ApiResponse;
import com.eidiko.supermarket_action_service.services.StocksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks/api")
public class StocksController {

    private final StocksService stocksService;


    public StocksController(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    //Add stocks
    @PostMapping("/addStocks")
    public ResponseEntity<ApiResponse<Stocks>> addStocks(@RequestBody Stocks stocks)
    {
        ApiResponse<Stocks> response = new ApiResponse<>(
                HttpStatus.CREATED,
                "Stocks added successfully",
                stocksService.addStocks(stocks)
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Update stocks
    @PatchMapping("/updateStocks/{id}")
    public ResponseEntity<String> updateStocks(@PathVariable int id,@RequestBody Stocks stocks)
    {
        stocksService.updateStocks(id,stocks);
        return ResponseEntity.ok("stocks updated successfully");
    }

    //Delete stocks based on id
    @DeleteMapping("/deleteStock/{id}")
    public ResponseEntity<ApiResponse<Stocks>> deleteStock(@PathVariable int id) throws StockNotFoundException {
        ApiResponse<Stocks> response = new ApiResponse<>(
                HttpStatus.NO_CONTENT,
                "Stocks DELETED successfully",
                stocksService.deleteStock(id)
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
