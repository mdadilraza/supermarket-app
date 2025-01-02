package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Stocks;
import com.eidiko.supermarket_action_service.response.ApiResponseEntity;
import com.eidiko.supermarket_action_service.services.StocksService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks/api")
@Tag(name = "Stocks_Api")
public class StocksController {

    private final StocksService stocksService;

    public StocksController(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    //Add stocks
    @PostMapping("/addStocks")
    public ResponseEntity<ApiResponseEntity<Stocks>> addStocks(@RequestBody Stocks stocks)
    {
        ApiResponseEntity<Stocks> response = new ApiResponseEntity<>(
                HttpStatus.CREATED,
                "Stocks added successfully",
                stocksService.addStocks(stocks)
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Update stocks details
    @PatchMapping("/updateStocks/{id}")
    public ResponseEntity<ApiResponseEntity<Stocks>> updateStocks(@PathVariable int id, @RequestBody Stocks stocks)
    {
        ApiResponseEntity<Stocks> apiResponseEntity =new ApiResponseEntity<>(
                HttpStatus.OK,
                "Stock details updated successfully",
                stocksService.updateStocks(id,stocks)
        );
        return new ResponseEntity<>(apiResponseEntity,HttpStatus.OK);
    }

    //Delete stocks based on id
    @DeleteMapping("/deleteStock/{id}")
    public ResponseEntity<ApiResponseEntity<String>> deleteStock(@PathVariable int id) throws StockNotFoundException, EmployeeNotFoundException {
        ApiResponseEntity<String> response = new ApiResponseEntity<>(
                HttpStatus.NO_CONTENT,
                "Stocks DELETED successfully",
                stocksService.deleteStock(id)
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //Updated stocks quantity
    @PatchMapping("/updateQuantity")
    public ResponseEntity<ApiResponseEntity<?>> updateStockQuantity(@RequestParam int id, @RequestParam int sellQuantity) throws InsufficientStockException {
        ApiResponseEntity<?> apiResponseEntity =new ApiResponseEntity<>(
                HttpStatus.OK,
                "Stocks updated successfully",
                stocksService.updateStockQuantity(id,sellQuantity)
        );
        return new ResponseEntity<>(apiResponseEntity,HttpStatus.OK);
    }

}
