package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.dao.IncentiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncentiveService {

    private final IncentiveRepo incentiveRepo;

    @Autowired
    public IncentiveService(IncentiveRepo incentiveRepo)
    {
        this.incentiveRepo=incentiveRepo;
    }





}
