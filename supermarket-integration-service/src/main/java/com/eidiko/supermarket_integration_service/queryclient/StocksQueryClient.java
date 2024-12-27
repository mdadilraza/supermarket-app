package com.eidiko.supermarket_integration_service.queryclient;

import com.eidiko.supermarket_integration_service.model.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="query-stocks",url = "http://10.0.0.42:8082/api/stocks")
public interface StocksQueryClient {

    @GetMapping("/{id}")
    Stock getStockById(@PathVariable int id);

    @GetMapping
     List<Stock> getAllEmployees();


}
