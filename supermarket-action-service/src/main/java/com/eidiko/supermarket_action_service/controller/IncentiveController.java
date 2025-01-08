package com.eidiko.supermarket_action_service.controller;

import com.eidiko.supermarket_action_service.model.Incentive;
import com.eidiko.supermarket_action_service.response.ApiResponseEntity;
import com.eidiko.supermarket_action_service.services.IncentiveService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Incentives_Api")
@RequestMapping("/incentive/api")
public class IncentiveController {

    private final IncentiveService incentiveService;

    public IncentiveController(IncentiveService incentiveService)
    {
        this.incentiveService=incentiveService;
    }

    @PostMapping("/addIncentive")
    public ResponseEntity<ApiResponseEntity<List<Incentive>>> addIncentive(@RequestBody Incentive incentive)
    {
        ApiResponseEntity<List<Incentive>> apiResponse=new ApiResponseEntity<>(
                HttpStatus.CREATED,
                "Incentives added",
                incentiveService.addIncentives(incentive)
        );
        return  new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }
}
