package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
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

    //Update stocks details
    @PatchMapping("/updateStocks/{id}")
    public ResponseEntity<ApiResponse<Stocks>> updateStocks(@PathVariable int id,@RequestBody Stocks stocks)
    {
        ApiResponse<Stocks>apiResponse=new ApiResponse<>(
                HttpStatus.OK,
                "Stock details updated successfully",
                stocksService.updateStocks(id,stocks)
        );
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    //Delete stocks based on id
    @DeleteMapping("/deleteStock/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStock(@PathVariable int id) throws StockNotFoundException, EmployeeNotFoundException {
        ApiResponse<String> response = new ApiResponse<>(
                HttpStatus.NO_CONTENT,
                "Stocks DELETED successfully",
                stocksService.deleteStock(id)
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //Updated stocks quantity
    @PatchMapping("/updateQuantity")
    public ResponseEntity<ApiResponse<?>> updateStockQuantity(@RequestParam int id, @RequestParam int sellQuantity) throws InsufficientStockException {
        ApiResponse<?> apiResponse=new ApiResponse<>(
                HttpStatus.OK,
                "Stocks updated successfully",
                stocksService.updateStockQuantity(id,sellQuantity)
        );
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}
