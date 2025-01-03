package com.eidiko.supermarket_integration_service.actionClient;

import com.eidiko.supermarket_integration_service.model.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="action-stock",url = "http://10.0.0.7:8081/stocks/api")
public interface StockActionClient {
    @PostMapping("/addStocks")
    ResponseEntity<String> addStocks(@RequestBody Stock stock);

    @PatchMapping("/updateStocks/{id}")
     ResponseEntity<String> updateStocks(@PathVariable int id, @RequestBody Stock stock);

    @DeleteMapping("/deleteStock/{id}")
     ResponseEntity<String> deleteStock(@PathVariable int id);
}
