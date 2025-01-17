package com.eidiko.supermarket_integration_service.controller;

import com.eidiko.supermarket_integration_service.dto.IncentiveDTO;
import com.eidiko.supermarket_integration_service.helper.ApiResponseEntity;
import com.eidiko.supermarket_integration_service.service.IncentiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/integration/incentives")
public class IncentiveController {

    private final IncentiveService incentiveService;

    public IncentiveController(IncentiveService incentiveService) {
        this.incentiveService = incentiveService;
    }
    @GetMapping
    public ResponseEntity<ApiResponseEntity<List<IncentiveDTO>>> getAllIncentieve(){
        return  incentiveService.getAllIncentieve();
    }


}
