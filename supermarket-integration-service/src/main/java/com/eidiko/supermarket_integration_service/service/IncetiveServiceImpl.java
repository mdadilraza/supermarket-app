package com.eidiko.supermarket_integration_service.service;

import com.eidiko.supermarket_integration_service.dto.IncentiveDTO;
import com.eidiko.supermarket_integration_service.helper.ApiResponseEntity;
import com.eidiko.supermarket_integration_service.queryclient.IncentiveQueryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncetiveServiceImpl implements IncentiveService{
    @Autowired
    private IncentiveQueryClient incentiveClient;

    public ResponseEntity<ApiResponseEntity<List<IncentiveDTO>>> getAllIncentieve(){
     return incentiveClient.getAllIncentives();
    }
}
