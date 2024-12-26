package com.eidiko.supermarket_query_service.service;

import com.eidiko.supermarket_query_service.exception.IncentiveNotFoundException;
import com.eidiko.supermarket_query_service.model.Incentive;

import java.util.List;

public interface IncentiveService {

    Incentive getIncentiveById(int id) throws IncentiveNotFoundException;
    List<Incentive> getAllIncentives();

}
