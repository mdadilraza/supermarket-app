package com.eidiko.query.controller;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.IncentiveDTO;
import com.eidiko.query.exception.IncentiveNotFoundException;
import com.eidiko.query.response.ApiResponse;
import com.eidiko.query.service.IncentiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<IncentiveDTO>> getIncentiveById(@PathVariable int id)
            throws IncentiveNotFoundException {
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK,
                "Incentive Fetched",
                incentiveService.getIncentiveById(id)
        ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<IncentiveDTO>>> getAllIncentives() {
        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK,
                "Incentives Fetched",
                incentiveService.getAllIncentives()
        ));
    }

}
