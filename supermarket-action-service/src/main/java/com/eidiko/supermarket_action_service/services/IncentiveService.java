package com.eidiko.supermarket_action_service.services;

import com.eidiko.supermarket_action_service.dao.IncentiveRepo;
import com.eidiko.supermarket_action_service.model.Incentive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncentiveService {

    private final IncentiveRepo incentiveRepo;

    public IncentiveService(IncentiveRepo incentiveRepo)
    {
        this.incentiveRepo=incentiveRepo;
    }

    public List<Incentive> addIncentives(Incentive incentive)
    {
        return incentiveRepo.addIncentive(incentive);
    }
}