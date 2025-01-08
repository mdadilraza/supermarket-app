package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.exceptions.EmployeeNotFoundException;
import com.eidiko.supermarket_action_service.exceptions.InsufficientStockException;
import com.eidiko.supermarket_action_service.exceptions.StockNotFoundException;
import com.eidiko.supermarket_action_service.model.Stock;
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
    public ResponseEntity<ApiResponseEntity<Stock>> addStocks(@RequestBody Stock stock)
    {
        ApiResponseEntity<Stock> response = new ApiResponseEntity<>(
                HttpStatus.CREATED,
                "Stocks added successfully",
                stocksService.addStocks(stock)
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Update stocks details
    @PatchMapping("/updateStocks/{id}")
    public ResponseEntity<ApiResponseEntity<Stock>> updateStocks(@PathVariable int id, @RequestBody Stock stock)
    {
        ApiResponseEntity<Stock> apiResponseEntity =new ApiResponseEntity<>(
                HttpStatus.OK,
                "Stock details updated successfully",
                stocksService.updateStocks(id, stock)
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
