package com.eidiko.supermarket_integration_service.actionClient;
import com.eidiko.supermarket_integration_service.dto.SaleRequest;
import com.eidiko.supermarket_integration_service.helper.ApiResponseEntity;
import com.eidiko.supermarket_integration_service.model.Sale;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="action-sale",url = "http://10.0.0.7:8081/sales/api")
public interface SaleActionClient {

    @PostMapping("/addSales")
    ResponseEntity<ApiResponseEntity<Sale>> addSales(@RequestBody SaleRequest saleRequest);

}
