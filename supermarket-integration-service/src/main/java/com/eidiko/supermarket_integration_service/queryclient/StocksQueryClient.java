package com.eidiko.supermarket_integration_service.queryclient;
import com.eidiko.supermarket_integration_service.helper.ApiResponseEntity;
import com.eidiko.supermarket_integration_service.model.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name ="query-stocks",url = "http://10.0.0.42:8082/api/stocks")
public interface StocksQueryClient {

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseEntity<Stock>> getStockById(@PathVariable int id);

    @GetMapping
     ResponseEntity<ApiResponseEntity<List<Stock>>> getAllStocks();

    @GetMapping("/name/{name}")
    ResponseEntity<ApiResponseEntity<List<Stock>>> getStocksByName(@PathVariable String name);


    }
