package com.eidiko.supermarket_action_service.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Incentives_Api")
@RequestMapping("/incentive/api")
public class IncentiveController {

    @PostMapping("/addIncentive")
    public void addIncentive()
    {

    }
}
