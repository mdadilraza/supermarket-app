package com.eidiko.query.controller;

import com.eidiko.query.dto.SaleDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;
import com.eidiko.query.exception.SaleNotFoundException;
import com.eidiko.query.response.ApiResponseEntity;
import com.eidiko.query.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@Tag(name = "Sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/{id}")
    @Operation(
            summary = "gets sale using id",
            description = "this end point allows to fetch stock data by using the sale id",
            parameters = {
                    @Parameter(name = "id", description = "Sale Id", required = true, in = ParameterIn.PATH)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<SaleDTO>> getSaleById(@PathVariable int id)
            throws SaleNotFoundException {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Sale Fetched",
                saleService.getSaleById(id))
        );
    }

    @GetMapping
    @Operation(
            summary = "gets all sales",
            description = "this end point allows to fetch all sales data",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<List<SaleDTO>>> getAllSales() {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Sales Fetched",
                saleService.getAllSales())
        );
    }

    @GetMapping("/employee/{employeeId}")
    @Operation(
            summary = "gets all sales using employee id",
            description = "this end point allows to fetch all sales data by using employee id",
            parameters = {
                    @Parameter(name = "employeeId", description = "Employee Id", required = true, in = ParameterIn.PATH)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<ApiResponseEntity<List<SaleDTO>>> getSalesByEmployeeID(@PathVariable int employeeId)
            throws EmployeeNotFoundException {
        return ResponseEntity.ok(new ApiResponseEntity<>(
                HttpStatus.OK,
                "Sales Fetched",
                saleService.getSalesByEmployeeId(employeeId))
        );
    }

}
