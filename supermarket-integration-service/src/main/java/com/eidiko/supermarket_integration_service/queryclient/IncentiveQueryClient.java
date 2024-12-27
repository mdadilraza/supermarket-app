package com.eidiko.supermarket_integration_service.queryclient;

import com.eidiko.supermarket_integration_service.model.Incentive;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name ="query-incentive",url = "http://10.0.0.42:8082/api/incentives")
public interface IncentiveQueryClient {
    @GetMapping("/{id}")
    public Incentive getIncentiveById(@PathVariable int id);

    @GetMapping
     List<Incentive> getAllIncentives();
}
