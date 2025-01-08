package com.eidiko.supermarket_integration_service.service;

import com.eidiko.supermarket_integration_service.queryclient.IncentiveQueryClient;
import com.eidiko.supermarket_integration_service.model.Incentive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncetiveServiceImpl implements IncentiveService{
    @Autowired
    private IncentiveQueryClient incentiveClient;

    public List<Incentive> getAllIncentieve(){
     return incentiveClient.getAllIncentives();
    }
}
