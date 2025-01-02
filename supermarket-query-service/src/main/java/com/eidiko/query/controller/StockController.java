package com.eidiko.query.controller;

import com.eidiko.query.exception.StockNotFoundException;
import com.eidiko.query.model.Stock;
import com.eidiko.query.response.ApiResponseEntity;
import com.eidiko.query.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.enterprise.inject.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@Tag(name = "Stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/{id}")
    @Operation(
            summary = "gets stock using id",
            description = "this end point allows to fetch stock data by using the stock id",
            parameters = {
                    @Parameter(name = "id", description = "Stock Id", required = true, in = ParameterIn.PATH)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<Stock>> getStockById(@PathVariable int id)
            throws StockNotFoundException {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Stock Fetched",
                stockService.getStockById(id)
        ));
    }

    @GetMapping
    @Operation(
            summary = "gets all stocks",
            description = "this end point allows to fetch all stocks data",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<List<Stock>>> getAllStocks() {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Stocks Fetched",
                stockService.getAllStocks()
        ));
    }

    @GetMapping("/name/{name}")
    @Operation(
            summary = "gets stock using stock name",
            description = "this end point allows to fetch stock data by using the stock name",
            parameters = {
                    @Parameter(name = "name", description = "Stock Name", required = true, in = ParameterIn.PATH)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<List<Stock>>> getStocksByName(@PathVariable String name) throws StockNotFoundException {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Stocks Fetched",
                stockService.getStocksByName(name)
        ));
    }

}
