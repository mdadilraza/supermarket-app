package com.eidiko.supermarket_integration_service.actionClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name ="action-incentive",url = "http://10.0.0.19:8081/employees/api")
public interface IncentiveActionClient {
}
