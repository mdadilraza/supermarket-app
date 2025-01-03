package com.eidiko.supermarket_integration_service.service;

import com.eidiko.supermarket_integration_service.dto.IncentiveDTO;
import com.eidiko.supermarket_integration_service.helper.ApiResponseEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IncentiveService {
    ResponseEntity<ApiResponseEntity<List<IncentiveDTO>>> getAllIncentieve();
}
