package com.eidiko.supermarket_integration_service.queryclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name ="query-sales",url = "http://10.0.0.42:8082/api/sales")
public interface SalesQueryClient {

}
