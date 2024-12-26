package com.eidiko.supermarket_query_service.controller;

import com.eidiko.supermarket_query_service.exception.IncentiveNotFoundException;
import com.eidiko.supermarket_query_service.model.Incentive;
import com.eidiko.supermarket_query_service.service.IncentiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/incentives")
public class IncentiveController {

    @Autowired
    private IncentiveService incentiveService;

    @GetMapping("/{id}")
    public Incentive getIncentiveById(@PathVariable int id) throws IncentiveNotFoundException {
        return incentiveService.getIncentiveById(id);
    }

    @GetMapping
    public List<Incentive> getAllIncentives() {
        return incentiveService.getAllIncentives();
    }

}
